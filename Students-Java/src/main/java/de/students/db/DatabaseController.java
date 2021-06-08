package de.students.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseController {

    private Connection connection;

    public void connectToDB() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String host = "dhbw.berski.de";
        int port = 3306;
        String database = "berski_dhbw_java";
        String user = "berski_dhbw_java";
        String password = "TO4ftmRsFx";

        String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + database + "?user=" + user + "&password=" + password;

        connection = DriverManager.getConnection(connectionString);
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException throwables) {
            return false;
        }
    }

    // für Testen des DatabaseControllers
    public static void main(String[] args) {
        DatabaseController databaseController = new DatabaseController();
        try {
            databaseController.connectToDB();
        } catch (Exception exc) {
            System.out.println("EXC: " + exc);
        }
        System.out.println("isConnected: " + databaseController.isConnected());
    }
}
