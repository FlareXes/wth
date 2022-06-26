package com.fireflaredb.bds.Models;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Object> readUser() throws SQLException, ClassNotFoundException {
        LogedinUser user = new LogedinUser("Users");
        String sqlQuery = "SELECT * FROM Users";
        ArrayList<Object> data = user.selectQuery(sqlQuery);
        return data;
    }

    @Override
    public void deleteUser() {
        // TODO Delete User
    }
}
