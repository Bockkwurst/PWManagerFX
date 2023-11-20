package com.example.pwmanagerfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LogInApplication extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
try{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn-view.fxml"));
    Parent root = loader.load();
    primaryStage.initStyle(StageStyle.UNDECORATED);
    LogInController controller = loader.getController();
    controller.setMain(this);

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Log In");
    primaryStage.show();
}catch (IOException e){
    e.printStackTrace();
}


    }

    public static void main(String[] args) {
        launch();
    }
}