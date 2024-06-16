package net.heydel.model;

import java.util.ArrayList;

public class User {
    private final static ArrayList<User> users = new ArrayList<User>();
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
}
