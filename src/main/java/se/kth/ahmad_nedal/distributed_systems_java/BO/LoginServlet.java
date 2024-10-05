package se.kth.ahmad_nedal.distributed_systems_java.BO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import se.kth.ahmad_nedal.distributed_systems_java.DB.UserDAO;

import java.io.IOException;

/**
 * LoginServlet is a servlet that handles user login requests.
 * It processes login credentials and establishes user sessions.
 */
@WebServlet("/login") // This annotation maps the servlet to the "/login" URL pattern.
public class LoginServlet extends HttpServlet {
    // Instance of UserDAO to interact with the database for user validation.
    private final UserDAO userDAO = new UserDAO();

    /**
     * Handles the POST request for user login.
     *
     * @param req  HttpServletRequest object containing the request data.
     * @param resp HttpServletResponse object for sending the response.
     * @throws ServletException if the request could not be handled.
     * @throws IOException      if an input or output error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve username and password parameters from the request.
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Validate the user credentials using UserDAO.
        if (userDAO.validateUser(username, password)) {
            // If validation is successful, create a session and store the username.
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            // Redirect to the products page after successful login.
            resp.sendRedirect("products");
        } else {
            // If validation fails, redirect back to the login page with an error flag.
            resp.sendRedirect("login.jsp?error=true");
        }
    }
}
