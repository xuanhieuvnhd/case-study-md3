package controller;

import model.Product;
import dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet",urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertProduct(request,response);
                break;
            case "edit":
                try {
                    updateProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                search(request,response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String code = request.getParameter("product_code");
        String name = request.getParameter("product_name");
        String category = request.getParameter("product_categorie");
        int quantity = Integer.parseInt(request.getParameter("product_quantity"));
        double price = Double.parseDouble(request.getParameter("product_price"));
        String pathImage = request.getParameter("product_img");
        Product product = new Product(code,name,category,quantity,price,pathImage);
        productDAO.updateProduct(product);
        request.setAttribute("message","Product information was updated");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/editProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("product_code");
        String name = request.getParameter("product_name");
        String category = request.getParameter("product_categorie");
        int quantity = Integer.parseInt(request.getParameter("product_quantity"));
        double price = Double.parseDouble(request.getParameter("product_price"));
        String pathImage = request.getParameter("product_img");
        Product newProduct = new Product(code,name,category,quantity,price,pathImage);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/addProduct.jsp");
        request.setAttribute("message", "New product was created");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            productDAO.insertProduct(newProduct);
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
                deleteProduct(request, response);
                break;
            case "view":
                break;
            case "display":
                listProduct(request,response);
                break;
            case "displayDress":
                listDress(request,response);
                break;
            case "displayTrousers":
                listTrousers(request,response);
                break;
            case "displayShirt":
                listShirt(request,response);
                break;
            case "displayPriceUp":
                listPriceUp(request,response);
                break;
            case "displayPriceDown":
                listPriceDown(request,response);
                break;
            default:
                home(request,response);
                break;
        }
    }


    private void listPriceDown(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productDAO.sortByPriceDown();
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

    private void listPriceUp(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productDAO.sortByPriceUp();
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

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Product> products = productDAO.selectProductByName(search);
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

    private void listShirt(HttpServletRequest request, HttpServletResponse response) {

        List<Product> products = productDAO.selectProductShirt();
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

    private void listTrousers(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productDAO.selectProductTrousers();
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

    private void listDress(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productDAO.selectProductDress();
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

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        try {
            productDAO.deleteProduct(code);
            List<Product> products = productDAO.selectAllProduct();
            request.setAttribute("listProduct",products);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/managerProduct.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/editProduct.jsp");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        Product product = productDAO.selectProductByCode(code);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/editProduct.jsp");
        request.setAttribute("product",product);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/addProduct.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
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

    private void home(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
        request.setAttribute("login","Login");
        request.setAttribute("signup","Signup");
        request.setAttribute("admin","admin");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
