package JDBC_LessonOne;

public class Main {
    public static void main(String[] args) {
        JDBCLoader.load();
        DBConnection connection = new DBConnection();
        DBWorker worker = new DBWorker(connection.connect());
        worker.getEmployeeContacts();
        worker.getSingleEmployees();
        worker.getManagers();
    }
}
