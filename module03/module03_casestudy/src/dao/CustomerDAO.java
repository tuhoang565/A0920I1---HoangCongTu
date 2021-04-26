package dao;

import models.Customer;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class CustomerDAO implements CRUDDao{
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";


    private static final String INSERT_CUSTOMERS = "insert into customer(customer_type_id, customer_name, customer_birthday," +
            "customer_gender, customer_id_card, customer_phone, customer_email, customer_address) values(?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?," +
            "customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    private static final String SEARCH_CUSTOMER = "select * from customer where customer_name = ?";

    public CustomerDAO() {
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

    @Override
    public void insert(Customer customer) throws SQLException{

            Connection connection = null;
            PreparedStatement statement = null;
            try {
                connection = getConnection();
                statement = connection.prepareStatement(INSERT_CUSTOMERS);

                java.util.Date myDate = new java.util.Date();
                myDate =customer.getCustomerBirthday();
                java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());


                statement.setInt(1, customer.getCustomerType());
                statement.setString(2, customer.getCustomerName());
                statement.setDate(3, sqlDate);
                statement.setString(4, customer.getCustomerGender());
                statement.setString(5, customer.getCustomerIdCard());
                statement.setString(6, customer.getCustomerPhone());
                statement.setString(7,customer.getCustomerEmail());
                statement.setString(8, customer.getCustomerAddress());
                statement.executeUpdate();
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
        }


    @Override
    public List getAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                int customerType = resultSet.getInt("customer_type_id");
                 String customerName = resultSet.getString("customer_name");
                 Date customerBirthday = resultSet.getDate("customer_birthday");
                 String customerGender = resultSet.getString("customer_gender");
                 String customerIdCard = resultSet.getString("customer_id_card");
                 String customerPhone = resultSet.getString("customer_phone");
                 String customerEmail = resultSet.getString("customer_email");
                 String customerAddress = resultSet.getString("customer_address");
                 customerList.add(new Customer(customerId, customerType, customerName, customerBirthday, customerGender,
                         customerIdCard, customerPhone, customerEmail, customerAddress));
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
        return customerList;
    }

    @Override
    public Customer getById(int customerId) {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int customerType = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                Date customerBirthday = resultSet.getDate("customer_birthday");
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard,
                        customerPhone, customerEmail, customerAddress);
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
        return customer;
    }

    @Override
    public void delete(int customerId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection =  getConnection();
            statement = connection.prepareStatement(DELETE_CUSTOMER);
            statement.setInt(1, customerId);
            statement.executeUpdate();
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
    }

    @Override
    public void update(Customer customer) {
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                java.util.Date myDate = new java.util.Date();
                myDate = customer.getCustomerBirthday();
                java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

                connection = getConnection();
                statement = connection.prepareStatement(UPDATE_CUSTOMER);
                statement.setInt(1, customer.getCustomerType());
                statement.setString(2, customer.getCustomerName());
                statement.setDate(3, sqlDate);
                statement.setString(4, customer.getCustomerGender());
                statement.setString(5, customer.getCustomerIdCard());
                statement.setString(6, customer.getCustomerPhone());
                statement.setString(7, customer.getCustomerEmail());
                statement.setString(8, customer.getCustomerAddress());
                statement.setInt(9, customer.getCustomerId());
                statement.executeUpdate();
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

    }

    @Override
    public Customer search(String searchInput) {
        Connection connection = null;
        PreparedStatement statement = null;
        Customer customer = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SEARCH_CUSTOMER);
            statement.setString(1, searchInput);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                int customerType = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                Date customerBirthday = resultSet.getDate("customer_birthday");
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard,
                        customerPhone, customerEmail, customerAddress);
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
        return customer;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
