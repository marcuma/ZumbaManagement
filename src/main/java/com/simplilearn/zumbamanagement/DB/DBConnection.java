package com.simplilearn.zumbamanagement.DB;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static DBConnection databaseConnection;
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class);

    private DBConnection() {

    }

    public static synchronized DBConnection getInstance() {
        if (databaseConnection == null)
            databaseConnection = new DBConnection();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        return databaseConnection;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://10.90.32.55:3306/zumba",
                    "marcuma",
                    "T0ri1890"
            );
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }

        return connection;
    }
}

