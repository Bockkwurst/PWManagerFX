package com.example.pwmanagerfx.Homescreen;

import com.example.pwmanagerfx.BaseApplication;
import com.example.pwmanagerfx.DatabaseConnection;
import com.example.pwmanagerfx.Entry.EntryInput;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.util.List;

import static com.example.pwmanagerfx.Entry.EntryController.loggedInUsername;


public class HomeApplication extends BaseApplication {
    private Stage homeStage;
    private FXMLLoader loader;

    @Override
    protected void initializeController(FXMLLoader loader){
        this.loader = loader;
        HomeController homeController = loader.getController();
        homeController.setMain(this);
        homeController.setLoader(loader);
        homeController.loadEntries();

    }


    @Override
    public void start(Stage homeStage) {
        initializeStage(homeStage, "/com/example/pwmanagerfx/Home-view.fxml");
    }
}
