package controller;

import model.Product;
import dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    List<Product> cart = new ArrayList<>();

    public void init() {
        productDAO = new ProductDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "order":
                addToCart(request,response);
                break;
            case "cart":
                displayCart(request,response);
                break;
            case "remove":
                remove(request,response);
                break;
        }

    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        String code = request.getParameter("code");
        Product product = productDAO.selectProductByCode(code);
        cart.remove(product);
        request.setAttribute("listCart",cart);
        int size = cart.size();
        int totalMount=0;
        for (int i=0;i< cart.size();i++){
            totalMount+= cart.get(i).getPrice();
        }
        request.setAttribute("totalMount",totalMount);
        request.setAttribute("size",size);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/cart.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        request.setAttribute("listCart",cart);
        int size = cart.size();
        int totalMount=0;
        for (int i=0;i< cart.size();i++){
            totalMount+= cart.get(i).getPrice();
        }
        request.setAttribute("totalMount",totalMount);
        request.setAttribute("size",size);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/cart.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        Product product = productDAO.selectProductByCode(code);
        cart.add(product);
        session.setAttribute("cart", cart);

        List<Product> products = productDAO.selectAllProduct();
        request.setAttribute("listProduct",products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/managerProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
