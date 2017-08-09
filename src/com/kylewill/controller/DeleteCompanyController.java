package com.kylewill.controller;

import com.kylewill.model.Company;
import com.kylewill.objectrelationalmap.CompanyMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteCompanyController extends DatabaseItemController implements Initializable{
    private String nameOfcompanyToDelete;
    @FXML private Button deleteButton;
    @FXML private Button cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancelButton.setOnMouseClicked(event -> stage.close());
        deleteButton.setOnMouseClicked(event -> deleteCompany());
    }

    public void setNameOfCompanyToDelete(String nameOfcompanyToDelete) {
        this.nameOfcompanyToDelete = nameOfcompanyToDelete;
    }

    private void deleteCompany() {
        List<Company> companies = CompanyMapper.readAll();
        for (Company someCompany : companies){
            if (someCompany.getCompanyName().equals(nameOfcompanyToDelete)){
                CompanyMapper.delete(someCompany);
            }
        }
        mainViewController.refreshCompanyNames();
        stage.close();
    }
}
