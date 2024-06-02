module main {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens main to javafx.fxml;
    opens main.controller to javafx.fxml;

    exports main;
    exports main.controller;
    exports main.connection;
    exports main.model;
    exports main.view;
}
