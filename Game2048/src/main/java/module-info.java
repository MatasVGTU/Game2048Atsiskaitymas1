module com.example.game2048 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.game2048 to javafx.fxml;
    exports com.example.game2048;
}