package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private final String URL ="jdbc:mysql://localhost:3306/SkyLine";
    private final String LOGIN = "root";
    private final String Password="11111111";

    public  Connection getConnection() {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, Password)) {
            return connection;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
