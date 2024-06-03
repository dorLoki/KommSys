package main.view;

import java.time.LocalDate;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import main.model.Chat;

public class ChatViewModel {
    private SimpleListProperty<Chat> chats;

    public ChatViewModel() {
        this.chats = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    public SimpleListProperty<Chat> chatsProperty() {
        return chats;
    }

    public void addChat(String name) {
        for (Chat chat : chats) {
            if (chat.nameProperty().get().equals(name)) {
                return;
            }
        }
        chats.add(new Chat(name));
    }

    public void addMessage(String name, String content, LocalDate date) {
        for (Chat chat : chats) {
            if (chat.nameProperty().get().equals(name)) {
                chat.addMessage(name, content, date);
                return;
            }
        }
        Chat chat = new Chat(name);
        chats.add(chat);
        chat.addMessage(name, content, date);
    }
}