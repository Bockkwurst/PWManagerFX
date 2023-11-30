package com.example.pwmanagerfx.Homescreen;

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

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import com.example.pwmanagerfx.LogIn.LogInApplication;

public class HomeController {

    public HomeApplication homeMain;
    public void setMain(HomeApplication LogIn) {
        this.homeMain = LogIn;
    }


}
