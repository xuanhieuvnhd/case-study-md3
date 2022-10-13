package dao;

import model.User;

import java.sql.*;

public class LoginDAO {
    public User checkLogin(String userName, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/democasestudy";
        String dbUser = "root";
        String dbPassword = "761321";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM users WHERE userName = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userName);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
//            String userName  =result.getString("userName");
            String passWord = result.getString("passWord");
            String email = result.getString("email");
            String address = result.getString("address");
            String role = result.getString("role");
            int phoneNumber = result.getInt("phoneNumber");
            user = new User(userName,passWord,email,phoneNumber,address,role);
        }

        connection.close();

        return user;
    }
}
