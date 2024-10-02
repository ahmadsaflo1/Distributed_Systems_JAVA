package se.kth.ahmad_nedal.distributed_systems_java.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URl = "jdbc:mysql://localhost:3306/webshop";
    private static final String User = "admin";
    private static final String Pass = "admin";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URl, User, Pass);
    }
}
