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
        LogedinUser user = new LogedinUser("");
        String sqlQuery = "SELECT * FROM Users";
        return user.selectUserQuery(sqlQuery);
    }

    public ArrayList<Object> readCluster() throws SQLException, ClassNotFoundException {
        LogedinUser cluster = new LogedinUser("");
        String sqlQuery = "SELECT * FROM Administrator";
        return cluster.selectMemberQuery(sqlQuery);
    }

    @Override
    public Boolean[] findUser(String phone, String password) {
            return User.login(phone, password);
    }

    public void insertMember(String doner, int age, String bg, String phone, String addr, String email) {
        LogedinUser user = new LogedinUser("Administrator");
        try {
            user.create(doner, age, bg, phone, addr, email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
