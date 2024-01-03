package com.example.pwmanagerfx.Homescreen;

import com.example.pwmanagerfx.Edit.EditApplication;
import com.example.pwmanagerfx.Entry.EntryApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import com.example.pwmanagerfx.LogIn.LogInApplication;

public class HomeController {

    @FXML
    private Button closeButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button entryButton;
    @FXML
    private Button editButton;
    @FXML
    private ListView pwList;

    public HomeApplication homeMain;
    public void setMain(HomeApplication logIn) {
        this.homeMain = logIn;
    }

    public void closeAction(ActionEvent e) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void handleLogOutAction(ActionEvent e) {
        try {
            LogInApplication logInApp = new LogInApplication();
            logInApp.start(new Stage());

            Stage stage = (Stage) logOutButton.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void handleEntryAction(ActionEvent e){
        try{
            EntryApplication entryApplication = new EntryApplication();
            entryApplication.start(new Stage());

            Stage stage = (Stage) entryButton.getScene().getWindow();
            stage.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void handleEditAction(ActionEvent e){
        try{
            EditApplication editApplication = new EditApplication();
            editApplication.start(new Stage());

            Stage stage = (Stage) editButton.getScene().getWindow();
            stage.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
