package se.kth.ahmad_nedal.distributed_systems_java.DB;

import se.kth.ahmad_nedal.distributed_systems_java.BO.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ProductDAO is a Data Access Object (DAO) class that provides methods for
 * interacting with the 'products' table in the database.
 */
public class ProductDAO {

    /**
     * Retrieves a list of products from the database.
     *
     * @return List<Product> - A list of Product objects retrieved from the database.
     */
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>(); // Initialize an empty list to hold products
        String query = "SELECT * FROM products"; // SQL query to select all products

        // Try-with-resources to ensure that resources are closed properly
        try (Connection connection = DBConnection.getConnection(); // Get a connection to the database
             PreparedStatement stmt = connection.prepareStatement(query)) { // Prepare the SQL statement

            ResultSet rs = stmt.executeQuery(); // Execute the query and get the results

            // Iterate through the ResultSet to populate the products list
            while (rs.next()) {
                int id = rs.getInt("id"); // Retrieve the product ID from the result set
                String name = rs.getString("name"); // Retrieve the product name
                double price = rs.getDouble("price"); // Retrieve the product price
                products.add(new Product(id, name, price)); // Create a new Product object and add it to the list
            }
        } catch (SQLException e) { // Catch any SQL exceptions that may occur
            e.printStackTrace(); // Print the stack trace for debugging
        }

        return products; // Return the list of products
    }
}
