package com.ahmudz.librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/lms";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection connection;

    public DatabaseConnection() {
        try {
            // Establish the connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute(String query, Object... params) throws SQLException {
        // Prepare the statement
        PreparedStatement statement = connection.prepareStatement(query);

        // Set parameters
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }

        // Execute the query
        statement.execute();
    }

    public ResultSet executeQuery(String query, Object... params) {
        ResultSet resultSet = null;
        try {
            // Prepare the statement
            PreparedStatement statement = connection.prepareStatement(query);

            // Set parameters
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            // Execute the query
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public int executeUpdate(String query, Object... params) throws SQLException {
        int rowsAffected = 0;

        // Prepare the statement
        PreparedStatement statement = connection.prepareStatement(query);

        // Set parameters
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }

        // Execute the update
        rowsAffected = statement.executeUpdate();

        return rowsAffected;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
