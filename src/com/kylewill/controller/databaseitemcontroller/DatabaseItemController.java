package com.kylewill.controller.databaseitemcontroller;

import com.kylewill.controller.MainViewController;
import javafx.stage.Stage;

public abstract class DatabaseItemController {
    protected Stage stage;
    protected MainViewController mainViewController;

    public DatabaseItemController(Stage stage, MainViewController mainViewController){
        this.stage = stage;
        this.mainViewController = mainViewController;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }
}
