package com.fireflaredb.bds;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}