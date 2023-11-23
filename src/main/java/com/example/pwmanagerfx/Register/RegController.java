package com.example.pwmanagerfx.Register;

import com.example.pwmanagerfx.LogIn.LogInApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class RegController {

    @FXML
    private Label regText;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField newUser;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField newPWrepeat;
    @FXML
    private Button regButton;
    @FXML
    private Button regClose;
    @FXML
    private Button returnButton;

    public void regcloseAction(ActionEvent e) {
        Stage stage = (Stage) regClose.getScene().getWindow();
        stage.close();
    }

public RegApplication regMain;
    public void setMain(RegApplication registration) {
        this.regMain = registration;
    }
}
