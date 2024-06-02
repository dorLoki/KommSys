package main.model;

import java.time.LocalDate;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class Chat {
    private StringProperty name;
    private SimpleListProperty<Message> messages;

    public Chat(String name) {
        this.name = new SimpleStringProperty(name);
        this.messages = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    public StringProperty nameProperty() {
        return name;
    }

    public SimpleListProperty<Message> messagesProperty() {
        return messages;
    }

    public void addMessage(String name, String content, LocalDate date) {
        messages.add(new Message(name, content, date));
    }
}