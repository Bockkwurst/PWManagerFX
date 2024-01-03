package com.example.pwmanagerfx.Entry;

import com.example.pwmanagerfx.BaseApplication;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class EntryApplication extends BaseApplication {

    @Override
    protected void initializeController(FXMLLoader loader) {
    EntryController addController = loader.getController();
    addController.setMain(this);
    }

    @Override
    public void start(Stage addStage){
        initializeStage(addStage, "/com/example/pwmanagerfx/Entry-view.fxml");
    }
}
