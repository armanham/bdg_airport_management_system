package com.bdg.db_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    public static final String URL = "jdbc:postgresql://localhost:5432/airport_db";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "2232";
    private static Connection connection;


    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void closeConnection() {
        if (connection == null) {
            throw new NullPointerException("Connection is null:");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}