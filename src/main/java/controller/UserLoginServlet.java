package controller;

import model.User;
import dao.LoginDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        LoginDAO userDao = new LoginDAO();

        try {
            User user = userDao.checkLogin(userName, password);
            String destPage = "view/login.jsp";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "view/home.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
