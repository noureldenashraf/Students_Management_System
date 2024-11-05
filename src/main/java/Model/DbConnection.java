package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    protected static final String URL = "jdbc:mariadb://localhost:3306/Student"; // Replace with your database name
    protected static final String USER = "root"; // Replace with your database username
    protected static final String PASSWORD = "2864"; // Replace with your database password


    public static Connection getConnection () {
        Connection connection = null;
        try {
            // Load MariaDB JDBC Driver
            Class.forName("org.mariadb.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to MariaDB established!");
        } catch (ClassNotFoundException e) {
            System.out.println("MariaDB JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to MariaDB failed.");
            e.printStackTrace();
        }
        return connection;
    }

}
