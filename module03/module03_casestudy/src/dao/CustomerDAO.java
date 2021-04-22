package dao;

import models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements CRUDDao{
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String INSERT_CUSTOMERS = "insert into customer(customer_type_id, customer_name, customer_birthday," +
            "customer_gender, customer_id_card, customer_phone, customer_email, customer_address) values(?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";

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
    public void insert(Object o) throws SQLException{
        if(o instanceof Customer) {
            Connection connection = null;
            PreparedStatement statement = null;
            try {
                connection = getConnection();
                statement = connection.prepareStatement(INSERT_CUSTOMERS);

                statement.setInt(1, ((Customer) o).getCustomerType());
                statement.setString(2, ((Customer) o).getCustomerName());
                statement.setDate(3, (Date) ((Customer) o).getCustomerBirthday());
                statement.setString(4, ((Customer) o).getCustomerGender());
                statement.setString(5, ((Customer) o).getCustomerIdCard());
                statement.setString(6, ((Customer) o).getCustomerPhone());
                statement.setString(7, ((Customer) o).getCustomerEmail());
                statement.setString(8, ((Customer) o).getCustomerAddress());
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
                int customerType = resultSet.getInt("customer_type_id");
                 String customerName = resultSet.getString("customer_name");
                 Date customerBirthday = resultSet.getDate("customer_birthday");
                 String customerGender = resultSet.getString("customer_gender");
                 String customerIdCard = resultSet.getString("customer_id_card");
                 String customerPhone = resultSet.getString("customer_phone");
                 String customerEmail = resultSet.getString("customer_email");
                 String customerAddress = resultSet.getString("customer_address");
                 customerList.add(new Customer(customerType, customerName, customerBirthday, customerGender, customerIdCard,
                 customerPhone, customerEmail, customerAddress));
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
    public Object getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void search(String string) {

    }
}
