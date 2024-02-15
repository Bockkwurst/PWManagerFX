package com.example.pwmanagerfx.Entry;

import com.example.pwmanagerfx.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntryInput {
    private String service;
    private String username;
    private String password;
    private int userId;

    public EntryInput(String service, String password, String username, int id) {
        this.service = service;
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getService() {
        return service;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setService(String service){
        this.service = service;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUser(String username){
        this.username = username;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    // Methode zum Hinzufügen eines Eintrags in die entries-Tabelle
    public static void addEntry(int userId, String service, String username, String password) {
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            try {
                // SQL-Statement für das Einfügen eines neuen Eintrags
                String insertQuery = "INSERT INTO entries (user_id, service, username, password) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                // Parameter setzen
                preparedStatement.setInt(1, userId);
                preparedStatement.setString(2, service);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, password);

                // SQL-Statement ausführen
                preparedStatement.executeUpdate();

                // Ressourcen freigeben
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Methode zum Abrufen der Benutzer-ID anhand des Benutzernamens
    public static int getUserId(String username) {
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            try {
                // SQL-Statement für das Abrufen der Benutzer-ID
                String selectQuery = "SELECT id FROM users WHERE username = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

                // Parameter setzen
                preparedStatement.setString(1, username);

                // SQL-Statement ausführen
                ResultSet resultSet = preparedStatement.executeQuery();

                // Benutzer-ID abrufen
                int userId = 0;
                if (resultSet.next()) {
                    userId = resultSet.getInt("id");
                }

                // Ressourcen freigeben
                resultSet.close();
                preparedStatement.close();
                connection.close();

                return userId;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public static void updateEntry(EntryInput entry) {
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            try {
                // SQL-Statement für das Aktualisieren eines Eintrags
                String updateQuery = "UPDATE entries SET service = ?, username = ?, password = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

                // Parameter setzen
                preparedStatement.setString(1, entry.getService());
                preparedStatement.setString(2, entry.getUsername());
                preparedStatement.setString(3, entry.getPassword());
                // Hier nehmen wir an, dass die ID des Eintrags in der EntryInput-Klasse vorhanden ist.
                // Je nach Datenbankstruktur müssten Sie möglicherweise die entsprechende Spalte verwenden.
                preparedStatement.setInt(4, entry.getUserId());

                // SQL-Statement ausführen
                preparedStatement.executeUpdate();

                // Ressourcen freigeben
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

