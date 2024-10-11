package o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/student";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connection is made");
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Connection is not  made");
           // e.printStackTrace();
        }
        return connection;
    }
}
