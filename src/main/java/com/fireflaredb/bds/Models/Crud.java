package com.fireflaredb.bds.Models;

import java.sql.*;
import java.util.ArrayList;

interface Crud {
    void create(String table, String doner, int age, String bg, String phone, String addr, String email);

    void read();

    void update();

    void delete(int id);
}

class Database implements Crud {

    private static Connection conn = null;
    private static Statement stat = null;

    Database() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Users.db");
        stat = conn.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS Users" +
                "(ID             INTEGER    PRIMARY KEY      NOT NULL             , " +
                " DONER          TEXT                        NOT NULL             , " +
                " PHONE          CHAR(20)                    NOT NULL       UNIQUE, " +
                " PASSWORD       INT                         NOT NULL)";
        stat.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS Administrator" +
                "(ID             INT     PRIMARY KEY     NOT NULL, " +
                " DONER          TEXT    NOT NULL, " +
                " AGE            INT     NOT NULL, " +
                " BG             TEXT    NOT NULL, " +
                " PHONE          CHAR(20)     NOT NULL, " +
                " ADDRESS        CHAR(50), " +
                " EMAIL          CHAR(50))";
        stat.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS Bloodbank" +
                "(ID             INT             PRIMARY KEY     NOT NULL, " +
                " BGT            CHAR(10)                        NOT NULL, " +
                " DATE           TEXT                            NOT NULL, " +
                " DONAR          CHAR(50))";
        stat.executeUpdate(sql);

        stat.close();
        conn.close();
    }

    public void executeQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Users.db");
        stat = conn.createStatement();
        conn.setAutoCommit(false);
        stat.executeUpdate(sqlQuery);
        conn.commit();
        stat.close();
        conn.close();
    }

    @Override
    public void create(String table, String doner, int age, String bg, String phone, String addr, String email) {
        String sqlQuery = String.format(
                "INSERT INTO %s (ID, DONER, AGE, BG, PHONE, ADDRESS, EMAIL) VALUES ('%s', %d, '%s', %s, '%s', '%s');",
                table, doner, age, bg, phone, addr, email);
        try {
            executeQuery(sqlQuery);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(String doner, String phone, String password) {
        String sqlQuery = String.format(
                "INSERT INTO Users (DONER, PHONE, PASSWORD) VALUES ('%s', %s, '%s');", doner, phone, password);
        try {
            executeQuery(sqlQuery);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
    }
}

class User {
    private static Connection conn = null;
    private static Statement stat = null;

    public static void createTable(String tableName) throws ClassNotFoundException, SQLException {
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s" +
                "(ID             INTEGER     PRIMARY KEY     NOT NULL, " +
                " DONER          TEXT                        NOT NULL, " +
                " AGE            INT                         NOT NULL, " +
                " BG             TEXT                        NOT NULL, " +
                " PHONE          Text                        NOT NULL, " +
                " ADDRESS        CHAR(500)                           , " +
                " EMAIL          CHAR(50)                            ) ", tableName);
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Cluster.db");
        stat = conn.createStatement();
        stat.executeUpdate(sqlQuery);
        stat.close();
        conn.close();
    }

    public static ArrayList<Object> selectQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Users.db");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        ResultSet result = stat.executeQuery(sqlQuery);
        ArrayList<Object> userDetails = new ArrayList<Object>();
        while (result.next()) {
            ArrayList<Object> details = new ArrayList<Object>();
            details.add(result.getString("phone"));
            details.add(result.getString("password"));
            userDetails.add(details);
        }

        conn.commit();
        stat.close();
        conn.close();
        return userDetails;
    }

    @SuppressWarnings("unchecked")
    public static boolean login(String phone, String password) {
        String sqlQuery = String.format("SELECT * FROM Users WHERE phone = %s", phone);
        try {
            ArrayList<Object> userCredentials = selectQuery(sqlQuery);
            if (userCredentials.size() == 1) {
                for (Object userC : userCredentials) {
                    ArrayList<String> creds = (ArrayList<String>) userC;
                    if (phone.equals(creds.get(0)) && password.equals(creds.get(1))) {
                        return true;
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

class LogedinUser implements Crud {

    private static Connection conn = null;
    private static Statement stat = null;
    private String table = null;

    public LogedinUser(String table) {
        this.table = table;
    }

    public void executeQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Cluster.db");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        stat.executeUpdate(sqlQuery);
        conn.commit();
        stat.close();
        conn.close();
    }

    public ArrayList<Object> selectQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Users.db");
//        conn = DriverManager.getConnection("jdbc:sqlite:Cluster.db");
        conn.setAutoCommit(false);
        stat = conn.createStatement();
        ResultSet result = stat.executeQuery(sqlQuery);

        ArrayList<Object> userDetails = new ArrayList<Object>();
        while (result.next()) {
            ArrayList<Object> details = new ArrayList<Object>();
            details.add(result.getInt("id"));
//            details.add(result.getInt("age"));
            details.add(result.getString("phone"));
            details.add(result.getString("doner"));
//            details.add(result.getString("bg"));
//            details.add(result.getString("address"));
//            details.add(result.getString("email"));
            userDetails.add(details);
        }

        conn.commit();
        stat.close();
        conn.close();

        return userDetails;
    }

    public void create(String doner, int age, String bg, String phone, String addr, String email) {
        String sqlQuery = String.format(
                "INSERT INTO %s (DONER, AGE, BG, PHONE, ADDRESS, EMAIL) VALUES ('%s', %d, '%s', %s, '%s', '%s');",
                table, doner, age, bg, phone, addr, email);
        try {
            executeQuery(sqlQuery);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
        String sqlQuery = String.format("SELECT * FROM %s", table);
        try {
            selectQuery(sqlQuery);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete(int id) {
        String sqlQuery = String.format("DELETE FROM %s WHERE ID = %d", table, id);
        try {
            executeQuery(sqlQuery);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(String table, String doner, int age, String bg, String phone, String addr, String email) {
        // TODO Auto-generated method stub
    }
}
