package com.example.pwmanagerfx.LogIn;

import com.example.pwmanagerfx.Homescreen.HomeApplication;
import com.example.pwmanagerfx.Register.RegApplication;
import com.example.pwmanagerfx.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

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

    public void closeAction(ActionEvent e) {
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

    public void validateLogIn() {
        DatabaseConnection connectNow = new DatabaseConnection();
        try (Connection connectDB = connectNow.getConnection()) {

            String verifyLogIn = "SELECT password FROM users WHERE username = ?";

            try (PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLogIn)) {
                preparedStatement.setString(1, user.getText());

                try (ResultSet queryResult = preparedStatement.executeQuery()) {
                    if (queryResult.next()) {
                        String hashedPasswordFromDB = queryResult.getString("password");

                        if (BCrypt.checkpw(masterpw.getText(), hashedPasswordFromDB)) {
                            // Benutzerdaten gefunden - erfolgreicher Login
                            try {
                                HomeApplication homeApp = new HomeApplication();
                                homeApp.start(new Stage());

                                Stage stage = (Stage) logIn.getScene().getWindow();
                                stage.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            welcomeText.setText("Falsches Passwort!");
                        }
                    } else {
                        welcomeText.setText("Benutzer nicht gefunden");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void RegisterPage(ActionEvent e) {
        try {
        RegApplication regApp = new RegApplication();
        regApp.start(new Stage());

        Stage stage = (Stage) register.getScene().getWindow();
        stage.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
