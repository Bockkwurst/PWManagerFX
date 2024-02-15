package com.example.pwmanagerfx.Register;

import com.example.pwmanagerfx.DatabaseConnection;
import com.example.pwmanagerfx.LogIn.LogInApplication;
import com.example.pwmanagerfx.Randomizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

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
    private Button closeButton;
    @FXML
    private Button returnButton;
    @FXML
    private Label yourPWLabel;
    @FXML
    private Label randomPassword;

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public void regCloseAction(ActionEvent e) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public RegApplication regMain;

    public void setMain(RegApplication registration) {
        this.regMain = registration;
    }

    public void returnPage(ActionEvent e) {
        try {
            LogInApplication logInApp = new LogInApplication();
            logInApp.start(new Stage());

            Stage stage = (Stage) returnButton.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void registerUser(ActionEvent e) {
        String firstNameValue = firstName.getText();
        String lastNameValue = lastName.getText();
        String newUserValue = newUser.getText();
        String newPasswordValue = newPassword.getText();
        String newPasswordRepeatValue = newPWrepeat.getText();

        if (newPasswordValue.equals(newPasswordRepeatValue)) {
            String hashedPassword = BCrypt.hashpw(newPasswordValue, BCrypt.gensalt());
            try (Connection connection = databaseConnection.getConnection()) {
                String sql = "INSERT INTO users (firstname, lastname, username, masterpassword) VALUES (?,?,?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, firstNameValue);
                    preparedStatement.setString(2, lastNameValue);
                    preparedStatement.setString(3, newUserValue);
                    preparedStatement.setString(4, hashedPassword);

                    preparedStatement.executeUpdate();
                    regText.setText("Regisrierung erfolgreich");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            regText.setText("Die Passwörter stimmen nicht überein.");
        }
    }
    public void handleGenerateAction(ActionEvent e) {
        String generatedPassword = Randomizer.generatePassword();

        newPassword.setText(generatedPassword);
        yourPWLabel.setText("Dein Passwort");
        randomPassword.setText(generatedPassword);
    }
}
