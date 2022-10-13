package controller;

import model.User;
import dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request,response);
                break;
            case "edit":
                try {
                    updateUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String address = request.getParameter("address");
        String role = request.getParameter("role");

        User user = new User(userName,password,email,phoneNumber,address,role);
        userDAO.updateUser(user);
        request.setAttribute("message","User information was updated");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/editUser.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String address = request.getParameter("address");
        User newUser = new User(userName,password,email,phoneNumber,address);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/signup.jsp");
        request.setAttribute("message", "New user was created");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            userDAO.insertUser(newUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "view":
                break;
            case "display":
                listUser(request,response);
                break;
            case "login":
                login(request,response);
                break;

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/login.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        try {
            userDAO.deleteUser(userName);
            List<User> users = userDAO.selectAllUser();
            request.setAttribute("listUser",users);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/managerUser.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/editUser.jsp");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        User user = userDAO.selectUserByUserName(userName);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/editUser.jsp");
        request.setAttribute("user",user);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/signup.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userDAO.selectAllUser();

        request.setAttribute("listUser",users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/managerUser.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

