package com.example.pwmanagerfx;

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
    public void logInOnAction(ActionEvent e) throws SQLException {
        if (!user.getText().isBlank() && !masterpw.getText().isBlank()) {
            //welcomeText.setText("Das ist nicht der Login den du suchst!");
            validateLogIn();
        } else {
            welcomeText.setText("Du musst etwas eingeben!");
        }
    }

    public void setMain(LogInApplication main) {
        this.main = main;
    }
    public void validateLogIn() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        try (Connection connectDB = connectNow.getConnection()) {

            String verifyLogIn = "SELECT count(1) FROM useraccounts WHERE Username = '" + user.getText() + "' AND Password = '" + masterpw.getText() + "'";

            try {
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogIn);

                while (queryResult.next()) {
                    if (queryResult.getInt(1) == 1) {
                        welcomeText.setText("Willkommen!");

                    } else {
                        welcomeText.setText("Das ist nicht der Login den du suchst!");

                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
