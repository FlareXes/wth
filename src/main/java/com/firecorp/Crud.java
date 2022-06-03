package com.firecorp;

import java.sql.*;

abstract class Crud {
    public abstract void create(String table, int id, String doner, String bg, long phone, String addr, String email);

    public abstract void read();

    public abstract void update();

    public abstract void delete();
}

class Database extends Crud {

    private Connection conn = null;
    private Statement stat = null;
    private String table;
    private int id;
    private String doner;
    private String bg;
    private long phone;
    private String addr;
    private String email;

    Database() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        stat = conn.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS Doner" +
                "(ID             INT     PRIMARY KEY     NOT NULL," +
                " DONER          TEXT    NOT NULL, " +
                " BG             TEXT    NOT NULL, " +
                " PHONE          INT     NOT NULL, " +
                " ADDRESS        CHAR(50), " +
                " EMAIL          CHAR(50))";
        stat.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS Administrator" +
                "(ID             INT     PRIMARY KEY     NOT NULL," +
                " DONER          TEXT    NOT NULL, " +
                " BG             TEXT    NOT NULL, " +
                " PHONE          INT     NOT NULL, " +
                " ADDRESS        CHAR(50), " +
                " EMAIL          CHAR(50))";
        stat.executeUpdate(sql);

        stat.close();
        conn.close();
    }

    public void executeQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        stat = conn.createStatement();
        conn.setAutoCommit(false);
        stat.executeUpdate(sqlQuery);
        conn.commit();
        stat.close();
        conn.close();
    }

    @Override
    public void create(String table, int id, String doner, String bg, long phone, String addr, String email) {
        String sqlQuery = String.format("INSERT INTO COUSTEMER (ID, DONER, BG, PHONE, ADDRESS, EMAIL) VALUES (%d, %s, %s, %l, %s, %s);", id, doner, bg, phone, addr, email);
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
    public void delete() {
        // TODO Auto-generated method stub

    }

}
