package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private final String URL = "jdbc:mysql://localhost:3306/SkyLine";
    private final String LOGIN = "root";
    private final String PASSWORD = "!!!!!!!!";
    private Connection connection = null;

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("successfully connected");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}