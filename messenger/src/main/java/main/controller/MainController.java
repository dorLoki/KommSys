package main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import main.App;
import main.model.Chat;
import main.model.Message;
import main.view.ChatViewModel;

public class MainController {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabChats;

    @FXML
    private Tab tabAktuelles;

    @FXML
    private Tab tabCommunity;

    @FXML
    private Tab tabAnrufe;

    @FXML
    private AnchorPane anchorChats;

    @FXML
    private AnchorPane anchorAktuelles;

    @FXML
    private AnchorPane anchorCommunitys;

    @FXML
    private AnchorPane anchorAnrufe;

    @FXML
    private ButtonBar buttonBar;

    @FXML
    private Button btnChatNew;

    @FXML
    private Button btnChatGroup;

    @FXML
    private Button btnChatUnread;

    @FXML
    private Button btnChatAll;

    @FXML
    private Text textHeader;

    @FXML
    private VBox vBox;

    private App app;

    private ChatViewModel viewModel;

    enum state {
        MAIN, CHAT
    }

    private state currentState = state.MAIN;

    private Chat currentChat;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    public void initialize() {
    }

    public void setChatViewModel(ChatViewModel viewModel) {
        this.viewModel = viewModel;
        // Höre auf Änderungen in der ObservableList und aktualisiere die
        // Benutzeroberfläche entsprechend

        viewModel.chatsProperty().addListener((ListChangeListener.Change<? extends Chat> change) -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    Platform.runLater(() -> {
                        if (currentState == state.MAIN) {
                            vBox.getChildren().addAll(change.getAddedSubList().stream()
                                    .map(this::createChatView)
                                    .collect(Collectors.toList()));
                        }
                        change.getAddedSubList().forEach(chat -> {
                            chat.messagesProperty()
                                    .addListener((ListChangeListener.Change<? extends Message> messageChange) -> {
                                        while (messageChange.next()) {
                                            if (messageChange.wasAdded()) {
                                                Platform.runLater(() -> {
                                                    if (currentState == state.CHAT && currentChat == chat) {
                                                        vBox.getChildren()
                                                                .addAll(messageChange.getAddedSubList().stream()
                                                                        .map(message -> {
                                                                            HBox hBox = new HBox();
                                                                            Label label = new Label(message
                                                                                    .senderProperty().get()
                                                                                    + ": "
                                                                                    + message.contentProperty().get());
                                                                            hBox.getChildren().add(label);
                                                                            return hBox;
                                                                        })
                                                                        .collect(Collectors.toList()));

                                                    }
                                                });
                                            }
                                        }
                                    });
                        });
                    });
                }
            }
        });
    }

    private Label createChatView(Chat chat) {
        Label chatLabel = new Label(chat.nameProperty().get());
        chatLabel.setOnMouseClicked(event -> handleChatClick(chat));
        chatLabel.setUserData(chat);
        return chatLabel;
    }

    private void handleChatClick(Chat chat) {
        currentState = state.CHAT;
        currentChat = chat;
        vBox.getChildren().clear();
        vBox.getChildren().addAll(chat.messagesProperty().get().stream()
                .map(message -> {
                    HBox hBox = new HBox();
                    Label label = new Label(message.contentProperty().get() + ": " + message.contentProperty().get());
                    hBox.getChildren().add(label);
                    return hBox;
                })
                .collect(Collectors.toList()));
    }

    @FXML
    private void newChat() {
        app.getConnection().send("Toni;Hallo, wie geht es dir?");
    }

    @FXML
    private void showGroupChatOnly() {
        app.getConnection().send("Luke;Gut, und dir?");
    }

    @FXML
    private void showUnreadChat() {
    }

    @FXML
    private void showAllChats() {
    }
}