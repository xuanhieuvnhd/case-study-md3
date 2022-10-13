package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUserByUserName(String userName);


    public List<User> selectAllUser();

    public boolean deleteUser(String userName) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
}
