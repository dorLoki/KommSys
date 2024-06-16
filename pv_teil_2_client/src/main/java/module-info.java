module net.heydel {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires com.google.protobuf;

    opens net.heydel to javafx.fxml;
    opens net.heydel.controller to javafx.fxml;

    exports net.heydel;
    exports net.heydel.controller;
    exports net.heydel.connection;
    exports net.heydel.model;
    exports net.heydel.view;
    exports net.heydel.protobuf;
}
