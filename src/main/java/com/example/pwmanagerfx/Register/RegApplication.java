package com.example.pwmanagerfx.Register;

import com.example.pwmanagerfx.LogIn.LogInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RegApplication extends Application {
    private Stage regStage;

    @Override
    public void start(Stage regStage) {
        this.regStage = regStage;
        try{
            FXMLLoader regLoader = new FXMLLoader(getClass().getResource("/com/example/pwmanagerfx/Reg-view.fxml"));
            Parent regRoot = regLoader.load();
            regStage.initStyle(StageStyle.UNDECORATED);
            RegController regcontroller = regLoader.getController();
            regcontroller.setMain(this);

            Scene scene = new Scene(regRoot);
            regStage.setScene(scene);
            regStage.setTitle("Log In");
            regStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void registration(String[] args) {
        launch();
    }
}
