package com.example.pwmanagerfx.Register;

import com.example.pwmanagerfx.BaseApplication;
import com.example.pwmanagerfx.LogIn.LogInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RegApplication extends BaseApplication {
    private Stage regStage;

    @Override
    protected void initializeController(FXMLLoader loader) {
        RegController regController = loader.getController();
        regController.setMain(this);
    }
    @Override
    public void start(Stage regStage) {
    initializeStage(regStage, "/com/example/pwmanagerfx/Reg-view.fxml");
    }
    public static void main(String[] args) {
        launch();
    }


}
