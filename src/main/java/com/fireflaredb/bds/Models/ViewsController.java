package com.fireflaredb.bds.Models;

import java.sql.SQLException;

interface Operations {
    void createUser(String name, String phone, String password);

    void deleteUser();
}

public class ViewsController implements Operations {
    @Override
    public void createUser(String name, String phone, String password) {
        try {
            new Database().create(name, phone, password);
            System.out.println("User Created\n");
            User.createTable(name + "_" + phone);
            System.out.println("User Database Created");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser() {
        // TODO Delete User
    }
}
