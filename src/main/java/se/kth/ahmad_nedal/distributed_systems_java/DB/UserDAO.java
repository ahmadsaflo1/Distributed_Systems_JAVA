package se.kth.ahmad_nedal.distributed_systems_java.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDAO is a Data Access Object (DAO) class that provides an interface for interacting with the
 * 'users' table in the database. It contains methods to validate user credentials.
 */
public class UserDAO {

    /**
     * Validates the user credentials against the database.
     *
     * This method checks if there exists a user in the 'users' table with the provided
     * username and password. It uses a prepared statement to prevent SQL injection attacks.
     *
     * @param username the username of the user trying to log in
     * @param password the password of the user trying to log in
     * @return true if the username and password match a record in the database, false otherwise
     */
    public static boolean validateUser(String username, String password) {
        // SQL query to check for matching username and password
        String query = "select * from users where username=? and password=?";

        // Try-with-resources to automatically close the connection and statement
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Setting parameters for the prepared statement
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Execute the query and check if a result exists
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if there is a matching record
        } catch (SQLException e) {
            // Print stack trace for any SQL exceptions
            e.printStackTrace();
        }
        return false; // Return false if no matching user is found or if an exception occurs
    }
}
