package com.example.pwmanagerfx.Entry;

import com.example.pwmanagerfx.Homescreen.HomeApplication;
import com.example.pwmanagerfx.Randomizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EntryController {


    @FXML
    private Button backButton;
    @FXML
    private TextField serviceTextfield;
    @FXML
    private TextField userTextfield;
    @FXML
    private TextField passwordTextfield;
    public EntryApplication entryMain;

    public void setMain(EntryApplication entryApplication) {
        this.entryMain = entryApplication;
    }


    public void returnPage(ActionEvent e) {
        try {
            HomeApplication homeApp = new HomeApplication();
            homeApp.start(new Stage());

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void handleGenerateAction(ActionEvent e) {
        String generatedPassword = Randomizer.generatePassword();

        passwordTextfield.setText(generatedPassword);
    }

}
