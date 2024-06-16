package net.heydel.connection;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.heydel.App;
import net.heydel.protobuf.ChatMessage;
import net.heydel.protobuf.CodeMessage;
import net.heydel.protobuf.LoginMessage;
import net.heydel.protobuf.MessageWrapper;

public class Connection {
    private Socket socket;
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
        MessageWrapper messageWrapper;
        try {
            while ((messageWrapper = MessageWrapper.parseDelimitedFrom(socket.getInputStream())) != null) {
                switch (messageWrapper.getMessageTypeCase()) {
                    case CHAT_MESSAGE:
                        processMessage(messageWrapper.getChatMessage());
                        break;
                    case CODE_MESSAGE:
                        processCodeMessage(messageWrapper.getCodeMessage());
                        break;
                    default:
                        System.out.println("Unknown message type?");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void processMessage(ChatMessage chatMessage) {
        String sender = chatMessage.getTo();
        String content = chatMessage.getContent();

        

        app.getChatViewModel().addMessage(sender, content, LocalDate.now());
    }

    private void processCodeMessage(CodeMessage codeMessage) {
        CodeMessageResolver.resolveCodeMessage(codeMessage.getCode());
    }

    public void send(String to, String message) {
        if (state == ConnectionState.CONNECTED || state == ConnectionState.LOGGED_IN) {
            ChatMessage chatMessage = ChatMessage.newBuilder().setTo(to).setContent(message).build();
            MessageWrapper messageWrapper = MessageWrapper.newBuilder().setChatMessage(chatMessage).build();
            try {
                messageWrapper.writeDelimitedTo(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalStateException("Not connected");
        }
    }

    public void login(String username, String password) {
        if (state != ConnectionState.CONNECTED) {
            throw new IllegalStateException("Not connected");
        }
        name = username;
        LoginMessage loginMessage = LoginMessage.newBuilder().setUsername(username).setPassword(password).build();
        MessageWrapper messageWrapper = MessageWrapper.newBuilder().setLoginMessage(loginMessage).build();
        try {
            messageWrapper.writeDelimitedTo(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (socket != null) {
                socket.close();
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

    public String getName() {
        return name;
    }
}
