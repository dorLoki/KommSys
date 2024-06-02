package main.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Message {
    private StringProperty content;
    private StringProperty sender;
    private ObjectProperty<LocalDate> date;

    public Message(String sender, String content, LocalDate date) {
        this.content = new SimpleStringProperty(content);
        this.sender = new SimpleStringProperty(sender);
        this.date = new SimpleObjectProperty<LocalDate>(date);
    }

    public StringProperty contentProperty() {
        return content;
    }

    public StringProperty senderProperty() {
        return sender;
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }
}