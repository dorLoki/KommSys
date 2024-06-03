package main.controller;

import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
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

    @FXML
    private Button btnSend;

    @FXML
    private TextField chatText;

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
                                                                            return createMessageBlock(message);
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

    private HBox createMessageBlock(Message message) {
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        hBox.getChildren().add(vBox);
        if (message.senderProperty().get().equals("Ich")) {
            hBox.setStyle("-fx-background-color: #f0f0f0;");
            vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        } else {
            hBox.setStyle("-fx-background-color: #e0e0e0;");
            // rechtsbündig
            hBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
            vBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        }
        Label label = new Label(message.contentProperty().get());
        label.wrapTextProperty().set(true);
        vBox.getChildren().add(label);
        Label time = new Label(message.dateProperty().get().toString());
        time.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        //time schriftart kleiner machen
        Font font = time.getFont();
        time.setFont(new Font(font.getName(), 8));
        vBox.getChildren().add(time);
        return hBox;
    }

    private HBox createChatView(Chat chat) {
        HBox hBox = new HBox();
        Label chatLabel = new Label(chat.nameProperty().get());
        chatLabel.setOnMouseClicked(event -> handleChatClick(chat));
        chatLabel.setUserData(chat);
        hBox.getChildren().add(chatLabel);
        Label newMessages = new Label();
        newMessages.textProperty().bind(chat.newMessagesProperty());
        hBox.getChildren().add(newMessages);
        return hBox;
    }

    private void handleChatClick(Chat chat) {
        currentState = state.CHAT;
        currentChat = chat;
        btnSend.setVisible(true);
        btnSend.setOnAction(event -> handleSendButton());
        chatText.setVisible(true);
        chatText.setOnAction(event -> handleSendButton());
        vBox.getChildren().clear();
        buttonBar.setVisible(false);
        HBox menu = new HBox();
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            currentState = state.MAIN;
            currentChat = null;
            vBox.getChildren().clear();
            buttonBar.setVisible(true);
            btnSend.setVisible(false);
            chatText.setVisible(false);
            chat.newMessagesProperty().set("");
            vBox.getChildren().addAll(viewModel.chatsProperty().get().stream()
                    .map(this::createChatView)
                    .collect(Collectors.toList()));
        });
        menu.getChildren().add(backButton);
        menu.getChildren().add(new Label(chat.nameProperty().get()));
        vBox.getChildren().add(menu);
        vBox.getChildren().addAll(chat.messagesProperty().get().stream()
                .map(message -> {
                    return createMessageBlock(message);
                })
                .collect(Collectors.toList()));
    }

    @FXML
    private void newChat() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("New Chat");
        alert.setHeaderText("Enter the name of the chat");
        TextField textField = new TextField();
        alert.getDialogPane().setContent(textField);
        alert.showAndWait();
        if (textField.getText() != null && !textField.getText().isEmpty()) {
            viewModel.addChat(textField.getText());
        }
    }

    @FXML
    private void showGroupChatOnly() {
    }

    @FXML
    private void showUnreadChat() {
    }

    @FXML
    private void showAllChats() {
    }

    @FXML
    private void handleSendButton() {
        System.out.println("handleSendButton");
        if (currentState == state.CHAT) {
            app.getConnection().send(currentChat.nameProperty().get() + ";" + chatText.getText());
            // vBox.getChildren().add(new Label("Ich: " + chatText.getText()));
            currentChat.addMessage("Ich", chatText.getText(), java.time.LocalDate.now());
            System.out.println("send: " + currentChat.nameProperty().get() + ";" + chatText.getText());
            chatText.clear();
        }
    }
}