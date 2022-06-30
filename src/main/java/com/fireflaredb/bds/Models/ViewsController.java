package com.fireflaredb.bds.Models;

import java.sql.SQLException;
import java.util.ArrayList;

interface Operations {
    void createUser(String name, String phone, String verified, String password);

    Boolean[] findUser(String phone, String password);
}

public class ViewsController implements Operations {
    @Override
    public void createUser(String name, String phone, String verified, String password) {
        try {
            new Database().create(name, phone, verified, password);
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
        return user.selectQuery(sqlQuery);
    }

    @Override
    public Boolean[] findUser(String phone, String password) {
            return User.login(phone, password);
    }
}

//class Temp extends ViewsController {
//    public static void main(String[] args) {
//       new ViewsController().createUser("B", "4321", "approved", "4321");
//    }
//}