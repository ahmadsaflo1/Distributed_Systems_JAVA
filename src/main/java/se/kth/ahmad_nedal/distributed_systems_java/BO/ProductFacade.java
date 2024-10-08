package se.kth.ahmad_nedal.distributed_systems_java.BO;

import se.kth.ahmad_nedal.distributed_systems_java.DB.ProductDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ProductFacade is responsible for providing a simplified interface
 * to retrieve products by interacting with the underlying data access object (DAO).
 *
 * This class acts as a business layer (BO) component that abstracts
 * the complexities of fetching product data from the database.
 */
public class ProductFacade {

    /**
     * Retrieves all products from the data access layer (ProductDAO) and
     * returns them as a list.
     *
     * @return a list containing all products.
     */
    public static List<Product> getAllProducts() {
        // Fetches products from the ProductDAO
        Collection<Product> products = ProductDAO.getProducts();
        // Returns the products as a List
        return new ArrayList<>(products);
    }
}
