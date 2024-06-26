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
    exports com.example.pwmanagerfx.Homescreen;
    opens com.example.pwmanagerfx.Homescreen to javafx.fxml;
    exports com.example.pwmanagerfx.Entry;
    opens com.example.pwmanagerfx.Entry to javafx.fxml;
}