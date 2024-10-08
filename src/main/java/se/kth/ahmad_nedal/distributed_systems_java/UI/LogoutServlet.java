package se.kth.ahmad_nedal.distributed_systems_java.UI;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * The LogoutServlet class handles user logout functionality in a web application.
 * It extends HttpServlet to utilize the servlet capabilities provided by the Jakarta EE framework.
 * This servlet is mapped to the URL pattern "/logout".
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    /**
     * Handles the POST request for logging out a user.
     * This method invalidates the current session, effectively logging the user out,
     * and then redirects the user to the login page.
     *
     * @param req  the HttpServletRequest object that contains the request made by the client
     * @param resp the HttpServletResponse object that contains the response returned to the client
     * @throws ServletException if an exception occurs that interferes with the servlet's normal operation
     * @throws IOException      if an input or output error occurs while handling the request
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the current session, if it exists
        HttpSession session = req.getSession(false);

        // Check if the session is not null (i.e., the user is logged in)
        if (session != null) {
            // Invalidate the session, effectively logging the user out
            session.invalidate();
        }

        // Redirect the user to the login page after logging out
        resp.sendRedirect("login.jsp");
    }
}
