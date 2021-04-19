package dao;

import model.User;

import java.util.List;

public interface IUserDAO {
    void insertUser(User user);
    List<User> getAllUser();
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    User searchUser(String country);
}
