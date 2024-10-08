package se.kth.ahmad_nedal.distributed_systems_java.UI;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import se.kth.ahmad_nedal.distributed_systems_java.BO.Product;
import se.kth.ahmad_nedal.distributed_systems_java.BO.ProductFacade;
import se.kth.ahmad_nedal.distributed_systems_java.BO.ProductInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a servlet that handles requests related to products.
 * It retrieves a list of products from the database and stores it in the session
 * before redirecting the user to a JSP page for displaying the products.
 */
@WebServlet("/products")  // This annotation maps the servlet to the "/products" URL
public class ProductServlet extends HttpServlet {
    /**
     * Handles the HTTP GET request for the "/products" URL.
     *
     * @param request  The HttpServletRequest object that contains the request from the client.
     * @param response The HttpServletResponse object that will be sent back to the client.
     * @throws IOException If an input or output error occurs during the operation.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve the list of products from the ProductDAO
        List<Product> productList = ProductFacade.getAllProducts();

        List<ProductInfo> productInfos = new ArrayList<>();
        for (Product product : productList){
            ProductInfo productInfo = new ProductInfo(product.getId(), product.getName(), product.getPrice());
            productInfos.add(productInfo);
        }

        // Get the current session or create a new one if it doesn't exist
        HttpSession session = request.getSession();

        // Store the list of products in the session under the attribute name "products"
        session.setAttribute("products", productInfos);

        // Redirect the client to the "products.jsp" page to display the products
        response.sendRedirect("products.jsp");
    }
}
