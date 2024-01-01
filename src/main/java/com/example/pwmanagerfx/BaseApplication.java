package com.example.pwmanagerfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;

import java.io.IOException;

public abstract class BaseApplication extends Application {

    protected void initializeStage(Stage stage, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            stage.initStyle(StageStyle.UNDECORATED);
            initializeController(loader);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("PasswordManager Copyright: Wolfgang Kremer");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void initializeController(FXMLLoader loader);

}
