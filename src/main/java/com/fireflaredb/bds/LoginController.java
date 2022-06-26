package com.fireflaredb.bds;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    public Button register_btn;
    @FXML
    public Button login_btn;
    @FXML
    private TextField phone_entry;
    @FXML
    public PasswordField password_entry;

    @FXML
    public void onLoginBtnClick(ActionEvent event) throws IOException {
        String phone = phone_entry.getText();
        String password = password_entry.getText();
        System.out.println(phone + " " + password);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inside-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Insider | FireFlareDB");
        stage.setScene(scene);
        stage.show();
    }

    public void onRegisterBtnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Sign Up | FireFlareDB");
        stage.setScene(scene);
        stage.show();
    }

//    public void onForgetPasswordLabelClick(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inside-view.fxml")));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setResizable(false);
//        stage.setTitle("Insider | FireFlareDB");
//        stage.setScene(scene);
//        stage.show();
//    }
}
