package com.example.pwmanagerfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LogInController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField user;
    @FXML
    private PasswordField masterpw;
    @FXML
    private ImageView lockpng;
    @FXML
    private Label logInText;
    @FXML
    private Button register;
    @FXML
    private Button logIn;
    @FXML
    private Button close;

public void closeAction(ActionEvent e){
    Stage stage = (Stage) close.getScene().getWindow();
    stage.close();
}
    public LogInApplication main;
    public void logInOnAction(ActionEvent e) {
        if (user.getText().isBlank() == false && masterpw.getText().isBlank() == false) {
            welcomeText.setText("Das ist nicht der Login den du suchst!");
        } else {
            welcomeText.setText("Du musst etwas eingeben!");
        }
    }

    public void setMain(LogInApplication main) {
        this.main = main;
    }
}