package JDBC_LessonOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String LOGIN = "root";
    private static final String PASSWORD = "!!!!!!!!";
    private static final String URL = "jdbc:mysql://localhost:3306/MyFunkDB";
    private Connection connection = null;

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("successfully connected");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
