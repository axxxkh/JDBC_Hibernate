package JDBC_LessonOne;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {
    private final Connection connection;

    public DBWorker(Connection connection) {
        this.connection = connection;
    }

    private Statement statement(Connection connection) {

        try {
            return connection.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void getEmployeeContacts() {
        final String employeeContacts = "SELECT EMPLOYEE.name, EMPLOYEE.tel, adress FROM (PERSONAL_INFO " +
                "JOIN EMPLOYEE " +
                "ON EMPLOYEE.id=PERSONAL_INFO.id)";
        try (ResultSet result = statement(connection).executeQuery(employeeContacts)) {
            while (result.next()) {
                System.out.printf(" %s tel:  %s adress: %s ", result.getString("name"),
                        result.getString("tel"), result.getString("adress"));
                System.out.println();
            }
        } catch (SQLException exception) {
            System.out.print("Something wrong");
            exception.printStackTrace();
        }
    }

    public void getSingleEmployees() {
        final String singleEmployees = "SELECT EMPLOYEE.name, EMPLOYEE.tel, birthdate FROM PERSONAL_INFO AS p \n" +
                "JOIN EMPLOYEE " +
                "ON EMPLOYEE.id = p.id " +
                "WHERE p.family = \"single\" or family =\"divorced\";";

        try (ResultSet result = statement(connection).executeQuery(singleEmployees)) {
            while (result.next()) {
                System.out.printf(" %s tel:  %s birthdate: %s ", result.getString("name"),
                        result.getString("tel"), result.getDate("birthdate"));
                System.out.println();
            }
        } catch (SQLException exception) {
            System.out.print("Something wrong");
            exception.printStackTrace();
        }
    }

    public void getManagers() {
        final String managers = "SELECT EMPLOYEE.name, EMPLOYEE.tel, PERSONAL_INFO.birthdate, position FROM STAFF_POSITIONS AS s " +
                "JOIN EMPLOYEE " +
                "ON EMPLOYEE.id=s.id " +
                "JOIN PERSONAL_INFO " +
                "ON PERSONAL_INFO.id=s.id " +
                "WHERE s.position = \"manager\";";

        try (ResultSet result = statement(connection).executeQuery(managers)) {
            while (result.next()) {
                System.out.printf(" %s tel:  %s birthdate: %s position %s", result.getString("name"),
                        result.getString("tel"), result.getDate("birthdate"),
                        result.getString("position"));
                System.out.println();
            }
        } catch (SQLException exception) {
            System.out.print("Something wrong");
            exception.printStackTrace();
        }
    }
}
