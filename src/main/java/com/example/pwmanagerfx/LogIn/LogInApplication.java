package com.example.pwmanagerfx.LogIn;

import com.example.pwmanagerfx.DatabaseConnection;
import com.example.pwmanagerfx.Register.RegApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LogInApplication extends Application {
    private Stage primaryStage;
    private DatabaseConnection databaseConnection;
    private LogInAuthentication logInAuthentication;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        try {
            databaseConnection = new DatabaseConnection();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pwmanagerfx/LogIn-view.fxml"));
            Parent root = loader.load();
            primaryStage.initStyle(StageStyle.UNDECORATED);

            LogInAuthentication logInAuthentication = new LogInAuthentication(databaseConnection);
            LogInController controller = new LogInController();
            controller.setMain(this);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Log In");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch();
    }
}