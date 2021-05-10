package dao;

import models.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";


    private static final String SELECT_ALL_CUSTOMER_TYPE = "select * from customer_type";
    private static final String GET_CUSTOMER_TYPE_BY_ID = "select * from customer_type where customer_type_id = ?";

    public CustomerTypeDAO() {
    }

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public CustomerType selectCustomerType(int customerTypeId){
        Connection connection = null;
        PreparedStatement statement = null;
        CustomerType customerType = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(GET_CUSTOMER_TYPE_BY_ID);
            statement.setInt(1, customerTypeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String customerTypeName = resultSet.getString("customer_type_name");
                customerType = new CustomerType(customerTypeId, customerTypeName);
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
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return customerType;
    }

    public List<CustomerType> selectAllCustomerType(){
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(customerTypeId, customerTypeName));
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
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return customerTypeList;
    }
}
