package net.heydel;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import net.heydel.model.CodeMessageCreater;
import net.heydel.model.User;
import net.heydel.protobuf.ChatMessage;
import net.heydel.protobuf.CodeMessage;
import net.heydel.protobuf.LoginMessage;
import net.heydel.protobuf.MessageWrapper;

public class ClientHandler implements Runnable {

    private Socket socket;
    private User user;
    private static ConcurrentHashMap<User, ClientHandler> users = new ConcurrentHashMap<>();

    public ClientHandler(Socket socket) {
        this.socket = socket;
        System.out.println("New client connected");
    }

    @Override
    public void run() {
        try {
            handleAuthentication();
            loadMessages();
            receiveMessages();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(user != null){
                System.out.println(user.getLogin() + " disconnected");
            } else {
                System.out.println("Client disconnected");
            }
            close();
        }
    }

    private void receiveMessages() throws IOException {
        MessageWrapper messageWrapper;
        while ((messageWrapper = MessageWrapper.parseDelimitedFrom(socket.getInputStream())) != null) {
            switch (messageWrapper.getMessageTypeCase()) {
                case CHAT_MESSAGE:
                    processClientMessage(messageWrapper.getChatMessage());
                    break;
                case CODE_MESSAGE:
                    processCodeMessage(messageWrapper.getCodeMessage());
                    break;
                default:
                    System.out.println("Unknown message type?");
                    break;
            }
        }
    }

    private void loadMessages() throws IOException {
        List<ChatMessage> messages = User.getMessages(user);
        if (messages != null) {
            for (ChatMessage chatMessage : messages) {
                ChatMessage chatMessageResponse = ChatMessage.newBuilder().setTo(chatMessage.getTo()).setContent(chatMessage.getContent()).build();
                MessageWrapper.newBuilder().setChatMessage(chatMessageResponse).build().writeDelimitedTo(socket.getOutputStream());
            }
        }
    }

    private void handleAuthentication() throws IOException {
        while (user == null) {
            MessageWrapper messageWrapper = MessageWrapper.parseDelimitedFrom(socket.getInputStream());
            if (messageWrapper == null) {
                continue;
            }
            if (messageWrapper.hasLoginMessage()) {
                LoginMessage loginMessage = messageWrapper.getLoginMessage();
                String login = loginMessage.getUsername();
                String password = loginMessage.getPassword();
                user = User.checkLogin(login, password);
                if (user == null) {
                    CodeMessageCreater.createCodeMessage(CodeMessageCreater.LOGIN_FAILED)
                            .writeDelimitedTo(socket.getOutputStream());
                    continue;
                }
                users.put(user, this);
                CodeMessageCreater.createCodeMessage(CodeMessageCreater.LOGIN_SUCCESS)
                        .writeDelimitedTo(socket.getOutputStream());
            }
        }
    }

    private void processCodeMessage(CodeMessage codeMessage) {
        // TODO
    }

    private void processClientMessage(ChatMessage chatMessage) throws IOException {
        String to = chatMessage.getTo();
        String content = chatMessage.getContent();
        User recipient = User.getUserByLogin(to);
        if (recipient == null) {
            CodeMessageCreater.createCodeMessage(CodeMessageCreater.USER_NOT_FOUND)
                    .writeDelimitedTo(socket.getOutputStream());
            return;
        }
        ClientHandler recipientHandler = users.get(recipient);
        if (recipientHandler == null) {
            CodeMessageCreater.createCodeMessage(CodeMessageCreater.USER_NOT_ONLINE)
                    .writeDelimitedTo(socket.getOutputStream());
            User.addMessage(recipient, content);
            return;
        }
        ChatMessage chatMessageResponse = ChatMessage.newBuilder().setTo(user.getLogin()).setContent(content).build();
        MessageWrapper.newBuilder().setChatMessage(chatMessageResponse).build().writeDelimitedTo(recipientHandler.socket.getOutputStream());
    }

    private void close() {
        if(user != null){
            users.remove(user);
        }
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
