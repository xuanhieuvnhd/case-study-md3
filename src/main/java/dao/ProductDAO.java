package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
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

    public ProductDAO() {
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
    @Override
    public void insertProduct(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)){
            preparedStatement.setString(1,product.getCode());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getCategory());
            preparedStatement.setInt(4,product.getQuantity());
            preparedStatement.setDouble(5,product.getPrice());
            preparedStatement.setString(6,product.getPathImage());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        }
        catch (SQLException e){
            System.out.println(e);;
        }
    }

    @Override
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

    @Override
    public List<Product> selectProductDress() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_DRESS);) {
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

    @Override
    public List<Product> selectProductShirt() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_SHIRT);) {
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

    @Override
    public List<Product> selectProductTrousers() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_TROUSERS);) {
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

    @Override
    public List<Product> sortByPriceUp() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_PRICE_UP);) {
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

    @Override
    public List<Product> sortByPriceDown() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_PRICE_DOWN);) {
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
                products.add(new Product(code, name, category, quantity, price, pathImage));

            }
        } catch (SQLException e) {
            System.out.println(e);
            ;
        }
        return products;
    }
    @Override
    public List<Product> selectProductByName(String inputSearch) {
        String search = "%" + inputSearch +"%";

        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);){
            preparedStatement.setString(1,search);
            preparedStatement.setString(2,search);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String code  =rs.getString("code");
                String name = rs.getString("name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String pathImage = rs.getString("pathImage");
               products.add(new Product(code,name,category,quantity,price,pathImage));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }



    @Override
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

    @Override
    public boolean deleteProduct(String code) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setString(1,code);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            statement.setString(1,product.getCode());
            statement.setString(2,product.getName());
            statement.setString(3,product.getCategory());
            statement.setInt(4, product.getQuantity());
            statement.setDouble(5,product.getPrice());
            statement.setString(6,product.getPathImage());
            statement.setString(7,product.getCode());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
