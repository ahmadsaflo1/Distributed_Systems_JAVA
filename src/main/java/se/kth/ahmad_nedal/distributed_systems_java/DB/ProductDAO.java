package se.kth.ahmad_nedal.distributed_systems_java.DB;

import se.kth.ahmad_nedal.distributed_systems_java.BO.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
             while (rs.next()){
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 double price = rs.getDouble("price");
                 products.add(new Product(id, name, price));
             }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }
}
