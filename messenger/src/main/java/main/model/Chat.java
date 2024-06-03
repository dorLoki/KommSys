package main.model;

import java.time.LocalDate;

import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class Chat {
    private StringProperty name;
    private SimpleListProperty<Message> messages;
    private SimpleStringProperty newMessages;

    public Chat(String name) {
        this.name = new SimpleStringProperty(name);
        this.messages = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.newMessages = new SimpleStringProperty("");
    }

    public StringProperty nameProperty() {
        return name;
    }

    public SimpleListProperty<Message> messagesProperty() {
        return messages;
    }

    public SimpleStringProperty newMessagesProperty() {
        return newMessages;
    }

    public void addMessage(String name, String content, LocalDate date) {
        messages.add(new Message(name, content, date));
        Platform.runLater(() -> {
            newMessages.set("(Neue Nachricht)");
        });
    }
}