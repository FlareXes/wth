package com.fireflaredb.bds;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Tab;

import java.net.URL;

import java.util.ResourceBundle;

public class InsiderController implements Initializable{
    @FXML
    public Tab memberTab;

    @FXML
    public Tab publicTab;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (! GlobalVariables.getUserVerified()) {
            System.out.println("first exec");
            memberTab.setDisable(true);
        } else {
            System.out.println("sec exec");
            memberTab.setDisable(false);
        }
    }
}
