module com.example.pwmanagerfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.pwmanagerfx to javafx.fxml;
    exports com.example.pwmanagerfx;
}