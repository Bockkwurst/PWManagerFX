package com.example.pwmanagerfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "PasswortManagerDB";
        String databaseUser = "root";
        String databasePassword = "2070";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch(Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }

}
