package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.connection.Connection;
import main.controller.LoginController;
import main.controller.MainController;
import main.view.ChatViewModel;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;

    private Connection connection;

    private ChatViewModel viewModel;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nicht WhatsApp");
        connection = new Connection(this);
        viewModel = new ChatViewModel();
        initRootLayout();

    }

    public void stop() {
        if (connection != null) {
            connection.shutdown();
        }
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("login.fxml"));
            GridPane rootLayout = (GridPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            LoginController controller = loader.getController();
            controller.init(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMainView(String name) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("main.fxml"));
            BorderPane layout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(layout);
            //scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            MainController controller = loader.getController();
            controller.setApp(this);
            controller.setChatViewModel(viewModel);
            this.primaryStage.setTitle("Logged in as " +name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ChatViewModel getChatViewModel() {
        return viewModel;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        launch();
    }
}