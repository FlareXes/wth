package com.fireflaredb.bds;

import com.fireflaredb.bds.API.Twillo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class OtpController {

    public TextField otp_entry;

    @FXML
    public void onLoginBtnClick(ActionEvent event) throws IOException {
        new RegisterController().onLoginBtnClick(event);
    }

    @FXML
    public void onOtpBtnClick(ActionEvent event) {
        otp_entry.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
//                    if (Twillo.verifyOTP(otp_entry.getText(), GlobalVariables.getCurrentLoginedUserPhone())) { //TODO uncomment this
                    if (true) {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("insider-view.fxml")));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setResizable(false);
                        stage.setTitle("Home | FireFlareDB");
                        stage.setScene(scene);
                        stage.show();
                    }
                }
            }
        });
    }
}
