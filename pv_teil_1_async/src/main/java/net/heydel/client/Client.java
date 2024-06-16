package net.heydel.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import net.heydel.model.TCPReceiver;
import net.heydel.model.TCPWriter;

public class Client implements Runnable {

    private Socket socket;
    private TCPReceiver receiver;
    private TCPWriter writer;
    private String login;
    private String password;

    public Client(String login, String password) {
        this.login = login;
        this.password = password;
        try {
            socket = new Socket("localhost", 8080);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        receiver = new TCPReceiver(socket);
        writer = new TCPWriter(socket);
    }

    @Override
    public void run() {
        String s;
        while ((s = receiver.receiveMessage()) != null) {
            processReceivedMessage(s);
        }
        System.out.println("stop client");
    }

    private void processReceivedMessage(String s) {
        String[] parts = s.split(";");
        if (parts.length == 1) {
            System.out.println(login + " received: " + s);
            return;
        }
        if (parts.length != 2) {
            System.out.println("Invalid message format from Server?");
            return;
        }
        String sender = parts[0];
        String message = parts[1];
        System.out.println(login + " received from " + sender + ": " + message);
    }

    public void login() {
        writer.write(login + " " + password);
    }

    public void sendMessage(String message) {
        writer.write(message);
    }
}
