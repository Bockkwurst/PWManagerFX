package com.example.pwmanagerfx.Homescreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeApplication extends Application {
    private Stage homeStage;

    @Override
    public void start(Stage homeStage) {
        this.homeStage = homeStage;
        try {
            FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/com/example/pwmanagerfx/Home-view.fxml"));
            Parent homeRoot = homeLoader.load();
            this.homeStage.initStyle(StageStyle.UNDECORATED);
            HomeController homecontroller = homeLoader.getController();
            homecontroller.setMain(this);

            Scene scene = new Scene(homeRoot);
            homeStage.setScene(scene);
            homeStage.setTitle("Log In");
            homeStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
