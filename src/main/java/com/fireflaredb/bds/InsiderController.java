package com.fireflaredb.bds;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

import java.net.URL;

import java.util.ResourceBundle;

public class InsiderController implements Initializable{
    @FXML
    public Tab memberTab;

    @FXML
    public Tab publicTab;

    @FXML
    public TableView publicTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        memberTab.setDisable(!GlobalVariables.getUserVerified());
    }
}
