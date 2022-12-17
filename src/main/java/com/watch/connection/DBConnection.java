package com.watch.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    private static final String URL = "jdbc:sqlserver://localhost;database=project_NLU_Watch;";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {

        System.out.println(DBConnection.getConnection());
    }
}
