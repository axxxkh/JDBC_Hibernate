package JDBC_LessonOne;

public class JDBCLoader {
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static void load() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
