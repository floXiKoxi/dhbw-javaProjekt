package de.students.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseController {

    private String host = "dhbw.berski.de";
    private int port = 3306;
    private String user = "berski_dhbw_java";
    private String password = "TO4ftmRsFx";
    private String database = "berski_dhbw_java";

    private Connection connection;
    private boolean connected = false;


    public void connectToDB() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + database + "?user=" + user + "&password=" + password;

        connection = DriverManager.getConnection(connectionString);
        connected = true;

    }


}
