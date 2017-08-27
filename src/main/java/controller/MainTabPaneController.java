package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainTabPaneController implements Initializable {
    private Stage currentStage;
    @FXML private EditLogEntriesTabController editEditLogEntriesTabController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setCurrentStage(Stage stage) {
        this.currentStage = stage;
        editEditLogEntriesTabController.setCurrentStage(currentStage);
    }
}