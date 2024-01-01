package com.example.pwmanagerfx.Homescreen;

import com.example.pwmanagerfx.BaseApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeApplication extends BaseApplication {
    private Stage homeStage;

    @Override
    protected void initializeController(FXMLLoader loader){
        HomeController homeController = loader.getController();
        homeController.setMain(this);
    }

    @Override
    public void start(Stage homeStage) {
        initializeStage(homeStage, "/com/example/pwmanagerfx/Home-view.fxml");
    }

}
