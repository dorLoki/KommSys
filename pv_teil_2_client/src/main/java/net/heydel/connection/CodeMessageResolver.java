package net.heydel.connection;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import net.heydel.App;

public class CodeMessageResolver {
    public static final int LOGIN_FAILED = 1;
    public static final int LOGIN_SUCCESS = 2;
    public static final int USER_NOT_FOUND = 10;
    public static final int USER_NOT_ONLINE = 11;

    public static void resolveCodeMessage(int code) {
        switch (code) {
            case LOGIN_FAILED:
                loginFailed();
                break;
            case LOGIN_SUCCESS:
                loginSuccess();
                break;
            case USER_NOT_FOUND:
                userNotFound();
                break;
            case USER_NOT_ONLINE:
                userNotOnline();
                break;
            default:
                break;
        }
    }

    private static void loginFailed() {
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Anmeldung fehlgeschlagen!");
            alert.showAndWait();
        });
    }

    private static void loginSuccess() {
        System.out.println("Anmeldung erfolgreich!");
        App app = App.getInstance();
        String name = app.getConnection().getName();
        Platform.runLater(() -> app.loadMainView(name));
    }

    private static void userNotFound() {
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Benutzer wurde nicht gefunden!");
            alert.showAndWait();
        });
    }

    private static void userNotOnline() {
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Nachricht konnte nicht gesendet werden. Der Benutzer ist offline!");
            alert.showAndWait();
        });
    }
}
