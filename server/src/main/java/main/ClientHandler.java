package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

import main.model.User;

public class ClientHandler implements Runnable {
    private Socket socket;
    private static ConcurrentHashMap<String, User> users;
    private User user;

    static {
        users = new ConcurrentHashMap<>();
        users.put("Luke", new User("Luke", "1234", null));
        users.put("Admin", new User("Admin", "1234", null));
        users.put("Toni", new User("Toni", "1234", null));
    }

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            // Authenticate client
            String username = reader.readLine();
            String password = reader.readLine();

            user = users.get(username);
            if (user == null) {
                writer.println("User not found");
                return;
            }

            if (user.getPassword().equals(password)) {
                writer.println("Authentication successful");
                user.setWriter(writer);
            } else {
                writer.println("Authentication failed");
                return;
            }

            // Handle further communication with client
            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println(user.getUsername() + " send: " + clientMessage);
                String response = processClientMessage(clientMessage);
                writer.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            user.setWriter(null);
            System.out.println("Client disconnected");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String processClientMessage(String message) {
        String[] parts = message.split(";");
        if (parts.length != 2) {
            System.out.println("Invalid message format");
            return "Invalid message format";
        }
        String recipient = parts[0];
        String content = parts[1];

        User recipientUser = users.get(recipient);
        if (recipientUser == null) {
            System.out.println("Recipient '" + recipient + "' was not found");
            return "Der Benutzer wurde nicht gefunden!";
        }
        if (recipientUser.sendMessage(user.getUsername(), content)) {
            return "Nachricht konnte nicht gesendet werden. Der Benutzer ist offline!";
        }
        return "Message sent to " + recipient;

    }
}
