package com.kylewill.controller.databaseitemcontroller;

import com.kylewill.model.Company;
import com.kylewill.objectrelationalmap.CompanyMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteCompanyController extends DatabaseItemController implements Initializable{
    private Company companyToDelete;
    @FXML private Label confirmationMessage;
    @FXML private Button deleteButton;
    @FXML private Button cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancelButton.setOnMouseClicked(event -> stage.close());
        deleteButton.setOnMouseClicked(event -> deleteCompany());
    }

    @Override
    protected void onMainViewControllerSet() {
        String nameOfcompanyToDelete = mainViewController.companyChoiceBox.getValue().toString();
        List<Company> companies = CompanyMapper.readAll();
        for (Company someCompany : companies){
            if (someCompany.getCompanyName().equals(nameOfcompanyToDelete)){
                companyToDelete = someCompany;
            }
        }
        confirmationMessage.setText("Are you sure you want to delete " + companyToDelete.getCompanyName() + "?");
    }

    private void deleteCompany() {
        CompanyMapper.delete(companyToDelete);
        mainViewController.refreshCompanyNames();
        stage.close();
    }
}
