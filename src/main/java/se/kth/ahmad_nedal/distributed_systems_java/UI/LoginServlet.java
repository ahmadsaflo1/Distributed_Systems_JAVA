package se.kth.ahmad_nedal.distributed_systems_java.UI;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import se.kth.ahmad_nedal.distributed_systems_java.DB.UserDAO;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet  extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(userDAO.validateUser(username, password)){
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("index.jsp");///////////////
        }else resp.sendRedirect("login.jsp?error=true");
    }
}
