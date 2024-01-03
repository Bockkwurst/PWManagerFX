package com.example.pwmanagerfx.Edit;

import com.example.pwmanagerfx.BaseApplication;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class EditApplication extends BaseApplication {
    @Override
    protected void initializeController(FXMLLoader loader) {
        EditController editController = loader.getController();
        editController.setMain(this);
    }

    @Override
    public void start(Stage editStage) {
        initializeStage(editStage, "/com/example/pwmanagerfx/Edit-view.fxml");
    }
}
