package net.heydel.server;

import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

import net.heydel.model.TCPReceiver;
import net.heydel.model.TCPWriter;
import net.heydel.model.User;

public class ClientHandler implements Runnable {

    private Socket socket;
    private User user;
    TCPReceiver receiver;
    TCPWriter writer;
    private static ConcurrentHashMap<User, ClientHandler> users = new ConcurrentHashMap<>();

    public ClientHandler(Socket socket) {
        this.socket = socket;
        receiver = new TCPReceiver(socket);
        writer = new TCPWriter(socket);
    }

    @Override
    public void run() {

        // Authenticate client
        while (user == null) {
            String auth = receiver.receiveMessage();
            if (auth == null) {
                continue;
            }
            String[] split = auth.split(" ");
            user = User.checkLogin(split[0], split[1]);
            if (user == null) {
                writer.write("Authentication failed");
                auth = receiver.receiveMessage();
            } else {
                users.put(user, this);
                writer.write("Authentication successful");
            }
        }
        String s;
        while ((s = receiver.receiveMessage()) != null) {
            System.out.println(user.getLogin() + " send: " + s);
            processClientMessage(s);

        }
        System.out.println(user.getLogin() + " disconnected");
        close();
    }

    private void processClientMessage(String s) {
        String[] parts = s.split(";");
        if (parts.length != 2) {
            writer.write("Invalid message format");
            return;
        }
        User recipient = User.getUserByLogin(parts[0]);
        if (recipient == null) {
            writer.write("Recipient not found");
            return;
        }
        ClientHandler recipientHandler = users.get(recipient);
        if (recipientHandler == null) {
            writer.write("Recipient is offline");
            return;
        }
        recipientHandler.writer.write(user.getLogin() + ";" + parts[1]);
    }

    private void close() {
        users.remove(user);
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
