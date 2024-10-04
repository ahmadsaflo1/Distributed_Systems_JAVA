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

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        Product product = new Product(productId, productName, productPrice);

        HttpSession session = request.getSession();
        List<Product> cartList = (List<Product>) session.getAttribute("cartList");
        if (cartList == null) cartList = new ArrayList<>();
        cartList.add(product);

        session.setAttribute("cartList", cartList);
        response.sendRedirect("products.jsp");

    }

}
