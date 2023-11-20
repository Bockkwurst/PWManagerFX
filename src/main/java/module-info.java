module com.example.pwmanagerfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pwmanagerfx to javafx.fxml;
    exports com.example.pwmanagerfx;
}