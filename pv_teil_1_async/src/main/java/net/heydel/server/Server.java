package net.heydel.server;

import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private final int PORT = 8080;
    private static Server serverInstance;
    private static ExecutorService executor = Executors.newCachedThreadPool();

    private boolean running = true;

    private Server() {

    }

    public static Server getInstance() {
        if (serverInstance == null) {
            serverInstance = new Server();
        }
        return serverInstance;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (running) {
                executor.execute(new ClientHandler(serverSocket.accept()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
    }

    public void stop() {
        serverInstance.running = false;
        serverInstance = null;
    }
}
