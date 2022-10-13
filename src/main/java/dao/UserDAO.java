package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/democasestudy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "761321";
    private static final String INSERT_USER_SQL = "INSERT INTO users" + "  (userName, password, email, address,phoneNumber) VALUES " +
            " (?,?,?,?,?);";
    private static final String SELECT_USER_BY_USERNAME = "select * from users where userName =?";
    private static final String SELECT_ALL_USER = "select * from users";
    private static final String DELETE_USER_SQL = "delete from users where userName= ?;";
    private static final String UPDATE_USER_SQL = "update users set userName = ?,password= ?, email =?, address = ?, phoneNumber=?,role = ? where userName = ?;";

    public UserDAO() {
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
    public void insertUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)){
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getAddress());
            preparedStatement.setInt(5,user.getPhoneNumber());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        }
        catch (SQLException e){
            System.out.println(e);;
        }
    }

    @Override
    public User selectUserByUserName(String userName) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);){
            preparedStatement.setString(1,userName);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
//                String userName  =rs.getString("userName");
                String passWord = rs.getString("passWord");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String role = rs.getString("role");
                int phoneNumber = rs.getInt("phoneNumber");
                user = new User(userName,passWord,email,phoneNumber,address,role);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String userName  =rs.getString("userName");
                String passWord = rs.getString("passWord");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String role = rs.getString("role");
                int phoneNumber = rs.getInt("phoneNumber");
                users.add(new User(userName,passWord,email,phoneNumber,address,role));

            }
        } catch (SQLException e) {
            System.out.println(e);;
        }
        return users;
    }

    @Override
    public boolean deleteUser(String userName) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);) {
            statement.setString(1,userName);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);) {
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getAddress());
            preparedStatement.setInt(5,user.getPhoneNumber());
            preparedStatement.setString(6,user.getRole());
            preparedStatement.setString(7,user.getUserName());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
