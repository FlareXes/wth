package com.fireflaredb.bds;

import com.fireflaredb.bds.Models.ViewsController;

import com.fireflaredb.bds.API.Twillo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    public Button register_btn;
    @FXML
    public Button login_btn;
    public Label forgetPassword_label;
    @FXML
    public PasswordField password_entry;
    @FXML
    private TextField phone_entry;

    @FXML
    public void onLoginBtnClick(ActionEvent event) throws IOException {
        String phone = phone_entry.getText();
        String password = password_entry.getText();
        ViewsController userViews = new ViewsController();
        Boolean[] existsVerify = userViews.findUser(phone, password);
        Boolean isUserExists = existsVerify[0];
        Boolean isUserVerified = existsVerify[1];
        GlobalVariables.setUserVerified(isUserVerified);

        if (password.equals("") || phone.equals("")) {
            phone_entry.setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
            password_entry.setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
            forgetPassword_label.setTextFill(Color.RED);
        } else if (isUserExists) {
            GlobalVariables.setCurrentLoginedUserPhone(phone);
            if (isUserVerified) {
               // Twillo.sendOTP(phone);// TODO uncomment this
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("otp-view.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setResizable(false);
                stage.setTitle("OTP Verification | FireFlareDB");
                stage.setScene(scene);
                stage.show();
                System.out.println("From LoginController Side Passed User Login With OTP");
            } else {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("insider-view.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setResizable(false);
                stage.setTitle("Insider | FireFlareDB");
                stage.setScene(scene);
                stage.show();
                System.out.println("From LoginController Side Passed User Login");
            }
        } else {
            phone_entry.setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
            password_entry.setStyle("-fx-border-color: red; -fx-prompt-text-fill: red");
            forgetPassword_label.setTextFill(Color.RED);
            System.out.println("From LoginController Side Failed User Login");
        }
    }

    @FXML
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
