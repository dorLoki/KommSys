package main.connection;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import main.App;

public class Connection {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private ConnectionState state;
    private ExecutorService executor;
    private Future<?> connectionTask;

    private String name = "";

    private App app;

    public Connection(App app) {
        this.state = ConnectionState.NOT_CONNECTED;
        this.executor = Executors.newSingleThreadExecutor();
        this.app = app;
    }

    public ConnectionState getState() {
        return state;
    }

    public void connect(String serverAddress, int port) throws Exception {
        if (state != ConnectionState.NOT_CONNECTED) {
            throw new IllegalStateException("Already connected or connecting");
        }
        state = ConnectionState.LOGIN_PROCESS;

        connectionTask = executor.submit(() -> {
            try {
                socket = new Socket(serverAddress, port);
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                state = ConnectionState.CONNECTED;
                System.out.println("Connected to server");

                // Start a listener thread to handle incoming messages
                new Thread(this::listenForMessages).start();
            } catch (Exception e) {
                state = ConnectionState.NOT_CONNECTED;
                e.printStackTrace();
            }
        });
    }

    private void listenForMessages() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // Handle incoming messages
                if (message.equals("Authentication successful")) {
                    state = ConnectionState.LOGGED_IN;
                    Platform.runLater(() -> app.loadMainView(name));
                } else {
                    processMessage(message);
                }
            }
        } catch (IOException e) { // TODO handle connection reset
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void processMessage(String message) {
        String[] parts = message.split(";");
        if (parts.length != 2) {
            switch (message) {
                case "Der Benutzer wurde nicht gefunden!":
                    Platform.runLater(() -> {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Benutzer wurde nicht gefunden!");
                        alert.showAndWait();
                    });
                    break;
                case "Invalid message format":
                    Platform.runLater(() -> {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Ungültiges Nachrichtenformat!");
                        alert.showAndWait();
                    });
                    break;
                case "Authentication failed":
                    Platform.runLater(() -> {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Anmeldung fehlgeschlagen!");
                        alert.showAndWait();
                    });
                    break;
                case "Nachricht konnte nicht gesendet werden. Der Benutzer ist offline!":
                    Platform.runLater(() -> {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Nachricht konnte nicht gesendet werden. Der Benutzer ist offline!");
                        alert.showAndWait();
                    });
                    break;
            }
            return;
        }
        String recipient = parts[0];
        String content = parts[1];
        app.getChatViewModel().addMessage(recipient, content, LocalDate.now());
    }

    public void send(String data) {
        if (state == ConnectionState.CONNECTED || state == ConnectionState.LOGGED_IN) {
            writer.println(data);
        } else {
            throw new IllegalStateException("Not connected");
        }
    }

    public void login(String username, String password) {
        if (state == ConnectionState.CONNECTED) {
            send(username);
            name = username;
            send(password);
            state = ConnectionState.LOGIN_PROCESS;
        } else {
            throw new IllegalStateException("Not connected");
        }
    }

    public void closeConnection() {
        try {
            if (socket != null) {
                socket.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            state = ConnectionState.NOT_CONNECTED;
        }
    }

    public void shutdown() {
        if (connectionTask != null) {
            connectionTask.cancel(true);
        }
        executor.shutdownNow();
        closeConnection();
    }

    public byte[] stringToByteArray(String message) {
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        int length = messageBytes.length;

        // Berechnen der Anzahl der Längen-Bytes
        int numLengthBytes = 0;
        while (length > 0) {
            numLengthBytes++;
            length >>= 7; // Verschieben um 7 Bit
        }

        byte[] result = new byte[numLengthBytes + messageBytes.length];
        length = messageBytes.length;
        for (int i = numLengthBytes - 1; i >= 0; i--) {
            result[i] = (byte) (length & 0x7F); // Die unteren 7 Bit setzen
            if (i < numLengthBytes - 1) {
                result[i] |= 0x80; // Das höchste Bit setzen
            }
            length >>= 7;
        }

        System.arraycopy(messageBytes, 0, result, numLengthBytes, messageBytes.length);
        return result;
    }

    public String byteArrayToString(byte[] bytes) {
        int length = 0;
        int shift = 0;
        int index = 0;

        while (index < bytes.length && (bytes[index] & 0x80) != 0) {
            length |= (bytes[index] & 0x7F) << shift;
            shift += 7;
            index++;
        }

        if (index < bytes.length) {
            length |= bytes[index++] << shift;
        }

        byte[] messageBytes = new byte[bytes.length - index];
        System.arraycopy(bytes, index, messageBytes, 0, messageBytes.length);
        return new String(messageBytes, StandardCharsets.UTF_8);
    }
}
