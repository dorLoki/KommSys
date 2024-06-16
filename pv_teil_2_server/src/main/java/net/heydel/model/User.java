package net.heydel.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import net.heydel.protobuf.ChatMessage;

public class User {
    private final static ArrayList<User> users = new ArrayList<User>();
    private final static ConcurrentHashMap<User, List<ChatMessage>> messages = new ConcurrentHashMap<User, List<ChatMessage>>();
    static {
        users.add(new User("luke", "1234"));
        users.add(new User("toni", "5678"));
        users.add(new User("jan", "9876"));
    }
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUserByLogin(String login) {
        for (User user : users) {
            if (user.login.equals(login)) {
                return user;
            }
        }
        return null;
    }

    public static User checkLogin(String login, String password) {
        User user = getUserByLogin(login);
        if (user != null) {
            if (user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static void addMessage(User user, String message) {
        List<ChatMessage> userMessages = messages.get(user);
        if (userMessages == null) {
            userMessages = new LinkedList<ChatMessage>();
            messages.put(user, userMessages);
        }
        userMessages.add(ChatMessage.newBuilder().setTo(user.getLogin()).setContent(message).build());
    }

    public static List<ChatMessage> getMessages(User user) {
        return messages.remove(user);
    }
}