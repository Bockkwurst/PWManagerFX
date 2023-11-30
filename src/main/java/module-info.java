module com.example.pwmanagerfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;

    opens com.example.pwmanagerfx to javafx.fxml;
    exports com.example.pwmanagerfx;
    exports com.example.pwmanagerfx.LogIn;
    opens com.example.pwmanagerfx.LogIn to javafx.fxml;
    exports com.example.pwmanagerfx.Register;
    opens com.example.pwmanagerfx.Register to javafx.fxml;
}