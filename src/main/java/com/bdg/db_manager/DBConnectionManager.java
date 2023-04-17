package com.bdg.db_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/airport_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "2232";
    private static Connection connection;

    private static DBConnectionManager dbConnectionManager;

    private DBConnectionManager(){
    }

    public static DBConnectionManager getInstance() {
        if (dbConnectionManager==null)
        {
            dbConnectionManager = new DBConnectionManager();
        }
        return dbConnectionManager;
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        if (connection == null) {
            throw new NullPointerException("Connection is null:");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}