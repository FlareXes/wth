package com.fireflaredb.bds;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserTableView {
    private int id;
    private String doner;
    private String password;

    UserTableView() {
        id = 0;
        doner = "";
        password = "";
    }

    UserTableView(int id, String doner, String password) {
        this.id = id;
        this.doner = doner;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoner() {
        return doner;
    }

    public void setDoner(String doner) {
        this.doner = doner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ObservableList<UserTableView> getUser() {
        ObservableList<UserTableView> users = FXCollections.observableArrayList();
        users.add(new UserTableView(1, "Data", "Data1234"));
        users.add(new UserTableView(1, "Data", "Dat1234"));
        users.add(new UserTableView(1, "Daa", "1234"));
        return users;
    }
}

