package dao;

import models.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenderDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL_GENDER = "select * from gender";
    private static final String SELECT_GENDER_BY_ID = "select * from gender where gender_id = ?";

    public GenderDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Gender> selectAllGender() {
        List<Gender> genderList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_GENDER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int genderId = resultSet.getInt("gender_id");
                String genderName = resultSet.getString("gender_name");
                genderList.add(new Gender(genderId, genderName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return genderList;
    }

    public Gender selectGenderById(int genderId) {
        Gender gender = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_GENDER_BY_ID);
            statement.setInt(1, genderId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String genderName = resultSet.getString("gender_name");
                gender = new Gender(genderId, genderName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return gender;
    }
}
