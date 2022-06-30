package com.fireflaredb.bds;

import com.fireflaredb.bds.Models.ViewsController;
import javafx.event.ActionEvent;
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

public class RegisterController {
    public TextField fullname_entry;
    public Button login_btn;
    public TextField phone_entry;
    public Button register_btn;
    public PasswordField password_entry2;
    public PasswordField password_entry1;
    public Label forgetPassword_label;

    public void onLoginBtnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Sign In | FireFlareDB");
        stage.setScene(scene);
        stage.show();
    }

    public void onRegisterBtnClick(ActionEvent event) {
        String fullname = fullname_entry.getText();
        String phone = phone_entry.getText();
        String password = (Objects.equals(password_entry1.getText(), password_entry2.getText())) ? password_entry1.getText() : null;
        if (password != null) {
            ViewsController userViews = new ViewsController();
            userViews.createUser(fullname, phone, "pending", password);
            fullname_entry.clear();
            phone_entry.clear();
            password_entry1.clear();
            password_entry2.clear();
            forgetPassword_label.setText("Registration Successful");
            forgetPassword_label.setTextFill(Color.LIGHTGREEN);
            System.out.println("From RegisterController Side Passed User Created");
        } else {
            password_entry1.clear();
            password_entry2.clear();
            forgetPassword_label.setText("Incorrect Password");
            forgetPassword_label.setTextFill(Color.RED);
            System.out.println("From RegisterController Side Failed User Created");
            System.out.println("Password Is Null");
        }
    }
}
