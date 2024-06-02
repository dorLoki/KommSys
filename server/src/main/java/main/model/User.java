package main.model;

import java.io.PrintWriter;

public class User {
    private String username;
    private String password;
    private PrintWriter writer;

    public User(String username, String password, PrintWriter writer) {
        this.username = username;
        this.password = password;
        this.writer = writer;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public boolean sendMessage(String from, String content){
        if(writer != null){
            writer.println(from + ";" + content);
            return false;
        } else{
            return true;
        }
    }
}
