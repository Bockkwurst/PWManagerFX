package com.example.pwmanagerfx.LogIn;

import org.mindrot.jbcrypt.BCrypt;
import com.example.pwmanagerfx.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInAuthentication {
    private final DatabaseConnection databaseConnection;

    public LogInAuthentication(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public boolean validateLogIn(String username, String password) {
        try (Connection connectDB = DatabaseConnection.getConnection()) {
            String verifyLogIn = "SELECT password FROM users WHERE username = ?";
            try(PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLogIn)){
                preparedStatement.setString(1, username);
                try(ResultSet queryResult = preparedStatement.executeQuery()){
                    if(queryResult.next()){
                        String hashedPasswordFromDB = queryResult.getString("password");
                        return BCrypt.checkpw(password, hashedPasswordFromDB);
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return false;
        } catch (SQLException e) {
        }
        return true;
    }

    public DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }
}
