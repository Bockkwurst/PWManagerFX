package com.example.pwmanagerfx.LogIn;

import com.example.pwmanagerfx.Entry.EntryController;
import com.example.pwmanagerfx.Homescreen.HomeApplication;
import com.example.pwmanagerfx.Register.RegApplication;
import com.example.pwmanagerfx.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.sql.*;

public class LogInController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField user;
    @FXML
    private PasswordField masterpw;
    @FXML
    private Button register;
    @FXML
    private Button logIn;
    @FXML
    private Button closeButton;

    private LogInAuthentication logInAuthentication;
    private LogInApplication logInApplication;


    public LogInController() {
        this.logInAuthentication = new LogInAuthentication(new DatabaseConnection());
    }


    public void setLogInApplication(LogInApplication logInApplication) {
        this.logInApplication = logInApplication;
    }

    public void closeAction(ActionEvent e) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        ;
    }

    public LogInApplication main;

    public void handleLogInAction() throws SQLException {
        if (!user.getText().isBlank() && !masterpw.getText().isBlank()) {
            if (logInAuthentication.validateLogIn(user.getText(), masterpw.getText())) {
                try {
                    EntryController.loggedInUsername = user.getText();

                    HomeApplication homeApp = new HomeApplication();
                    homeApp.start(new Stage());

                    Stage stage = (Stage) logIn.getScene().getWindow();
                    stage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                welcomeText.setText("Das ist nicht der Login, den du suchst!");
            }
        } else {
            welcomeText.setText("Du musst etwas eingeben!");
        }
    }

    public void setMain(LogInApplication main) {
        this.main = main;
    }

    public void RegisterPage(ActionEvent e) {
        try {
            RegApplication regApp = new RegApplication();
            regApp.start(new Stage());

            Stage stage = (Stage) register.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void handleEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                handleLogInAction();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
