package dao;

import model.User;
import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDAOImpl implements IUserDAO {
    private static final String INSERT_USER = "insert into users(name, email, country) values(?, ?, ?)";
    private static final String SELECT_ALL_USER = "select * from users";
    private static final String UPDATE_USER = "update users set name = ?, email = ?, country = ? where id = ?";
    private static final String DELETE_USER = "delete from users where id = ?";
    private static final String SELECT_USER_BY_ID = "select * from users where id = ?";
    private static final String SELECT_USER_BY_COUNTRY = "select * from users where country = ?";


    @Override
    public void insertUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(INSERT_USER);

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAllUser() {
        Connection connection = null;
        PreparedStatement statement = null;
        List<User> userList = new ArrayList<>();
        try{
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return userList;
    }

    @Override
    public void updateUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(UPDATE_USER);


            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteUser(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(DELETE_USER);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public User getUserById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        User user = null;
        try{
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_USER_BY_ID);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return user;
    }

    public User searchUser(String country){
        Connection connection = null;
        PreparedStatement statement = null;
        User user = null;
        try{
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            statement.setString(1, country);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return user;
    }
}
