package com.example.pwmanagerfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LogInController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField user;
    @FXML
    private PasswordField masterpw;
    @FXML
    private ImageView lockpng;

    public LogInApplication main;

    public void setMain(LogInApplication main) {
        this.main = main;
    }
}