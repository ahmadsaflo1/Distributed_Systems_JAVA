package se.kth.ahmad_nedal.distributed_systems_java.BO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AddToCartServlet is a servlet that handles adding products to the user's shopping cart.
 * It receives product details from the client, updates the session's cart, and redirects to the products page.
 */
@WebServlet("/add-to-cart") // Maps the servlet to the "/add-to-cart" URL
public class AddToCartServlet extends HttpServlet {

    /**
     * Handles POST requests for adding a product to the shopping cart.
     *
     * @param request  The HttpServletRequest object that contains the request the client made of the servlet.
     * @param response The HttpServletResponse object that contains the response the servlet returns to the client.
     * @throws ServletException If the request for the POST could not be handled.
     * @throws IOException      If an input or output error is detected when the servlet handles the request.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve product details from the request parameters
        int productId = Integer.parseInt(request.getParameter("productId")); // Extract the product ID
        String productName = request.getParameter("productName"); // Extract the product name
        double productPrice = Double.parseDouble(request.getParameter("productPrice")); // Extract the product price

        // Create a new Product object with the extracted details
        Product product = new Product(productId, productName, productPrice);

        // Get the current session or create a new one if it doesn't exist
        HttpSession session = request.getSession();

        // Retrieve the cartList from the session, or create a new one if it doesn't exist
        List<Product> cartList = (List<Product>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new ArrayList<>(); // Initialize a new ArrayList if cartList is null
        }

        // Add the product to the cart list
        cartList.add(product);

        // Update the session attribute with the modified cart list
        session.setAttribute("cartList", cartList);

        // Redirect the client to the products page after adding the product
        response.sendRedirect("products.jsp");
    }
}
