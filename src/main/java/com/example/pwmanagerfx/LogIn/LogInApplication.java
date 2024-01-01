package com.example.pwmanagerfx.LogIn;

import com.example.pwmanagerfx.BaseApplication;
import com.example.pwmanagerfx.DatabaseConnection;
import com.example.pwmanagerfx.Register.RegApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LogInApplication extends BaseApplication {
    private Stage primaryStage;
    private DatabaseConnection databaseConnection;
    private LogInAuthentication logInAuthentication;

    @Override
    protected void initializeController(FXMLLoader loader){
        LogInController logInController = loader.getController();
        logInController.setMain(this);
    }

    @Override
    public void start(Stage logInStage) {
        initializeStage(logInStage, "/com/example/pwmanagerfx/LogIn-view.fxml");
            databaseConnection = new DatabaseConnection();
            LogInAuthentication logInAuthentication = new LogInAuthentication(databaseConnection);
    }

    public static void main(String[] args) {
        launch();
    }
}