package com.example.pwmanagerfx;

import com.example.pwmanagerfx.Entry.EntryInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DatabaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection() {
        String databaseName = "passwortmanagerdb";
        String databaseUser = "root";
        String databasePassword = "2070";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }

    public static List<EntryInput> getEntriesForUsername(String username) {
        List<EntryInput> entries = new ArrayList<>();

        try (Connection connectDB = DatabaseConnection.getConnection()) {
            String selectEntriesQuery = "SELECT * FROM entries WHERE user_id = (SELECT id FROM users WHERE username = ?)";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(selectEntriesQuery)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        EntryInput entry = new EntryInput(
                                resultSet.getString("service"),
                                resultSet.getString("password"),
                                resultSet.getString("username"),
                                resultSet.getInt("user_id")
                        );
                        entries.add(entry);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entries;
    }
}
