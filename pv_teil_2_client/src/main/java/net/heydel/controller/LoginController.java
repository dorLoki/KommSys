package net.heydel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.heydel.App;

public class LoginController {
    private App app;
    private static final int PORT = 8080;
    
    @FXML
    private TextField usernameInput;
    
    @FXML
    private TextField passwordInput;

    @FXML
    private Label errorMessage;

    @FXML
    void loginButtonClicked(ActionEvent event) {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        app.getConnection().login(username, password);
    }

    public void init(App app) {
        this.app = app;
        try {
            app.getConnection().connect("localhost", PORT);
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage.setText("Could not connect to server");
        }
    }
}
