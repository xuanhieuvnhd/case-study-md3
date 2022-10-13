package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/democasestudy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "761321";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO products" + "  (code,name,category,quantity,price,pathImage) VALUES " +
            " (?,?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_CODE = "select * from products where code =?";
    private static final String SELECT_PRODUCT_BY_NAME = "select * from products where name like ? or code like ?";
    private static final String SELECT_ALL_PRODUCTS = "select * from products";
    private static final String DELETE_PRODUCT_SQL = "delete from products where code = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update products set code = ?,name= ?, category =?, quantity = ?, price =? , pathImage =? where code = ?;";
    private static final String SELECT_PRODUCT_DRESS ="SELECT * from products where category='dress'";
    private static final String SELECT_PRODUCT_SHIRT ="SELECT * from products where category = 'shirt'";
    private static final String SELECT_PRODUCT_TROUSERS ="SELECT * from products where category = 'trousers'";
    private static final String SORT_BY_PRICE_UP ="SELECT * FROM products order by price ASC";
    private static final String SORT_BY_PRICE_DOWN ="SELECT * FROM products order by price DESC";

    public OrderDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    public Product selectProductByCode(String code) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_CODE);){
            preparedStatement.setString(1,code);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name  =rs.getString("name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String pathImage = rs.getString("pathImage");
                product = new Product(code,name,category,quantity,price,pathImage);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String pathImage = rs.getString("pathImage");
                products.add(new Product(code,name,category,quantity,price,pathImage));

            }
        } catch (SQLException e) {
            System.out.println(e);;
        }
        return products;
    }
}
