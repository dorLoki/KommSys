package main.connection;
import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javafx.application.Platform;
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
                } else{
                    processMessage(message);
                }
            }
        } catch (IOException e) { //TODO handle connection reset
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void processMessage(String message) {
        String[] parts = message.split(";");
        if (parts.length != 2) {
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
}
