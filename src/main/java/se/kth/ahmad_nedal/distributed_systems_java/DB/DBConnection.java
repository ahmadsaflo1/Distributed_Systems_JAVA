package se.kth.ahmad_nedal.distributed_systems_java.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DBConnection class is responsible for establishing a connection to the MySQL database.
 * It provides a static method to get a Connection object that can be used to interact with the database.
 */
public class DBConnection {

    // Database connection parameters
    private static final String URl = "jdbc:mysql://localhost:3306/webshop"; // URL for the MySQL database
    private static final String User = "root"; // Username for database authentication
    private static final String Pass = "2441985aA@"; // Password for database authentication

    /**
     * Gets a connection to the MySQL database.
     *
     * @return A Connection object to the database.
     * @throws SQLException If there is an error connecting to the database.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Print stack trace if the driver class is not found
            e.printStackTrace();
        }
        // Return a new database connection
        return DriverManager.getConnection(URl, User, Pass);
    }
}
