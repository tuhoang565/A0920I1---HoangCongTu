package repository;




import model.Customer;
import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{
    private String jdbcURL = "jdbc:mysql://localhost:3306/democ09?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "10100904";
    private CustomerTypeRepositoryImpl customerTypeRepository= new CustomerTypeRepositoryImpl();

    public CustomerRepositoryImpl() {
    }

    private static final String INSERT_CUSTOMER = "INSERT INTO customer (name_customer,birthday,gender,id_customer_type) VALUES " +
            " (?,?,?,?);";
    private static final String SELECT_CUSTOMER = "SELECT * FROM customer";
    private static final String DELETE_CUS_SQL = "delete from customer where id_customer = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE id_customer = ? ";

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

    public void save(Customer customer) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER)) {
            preparedStatement.setString(1, customer.getNameCustomer());
            String[] date = customer.getBirthday().split("/");
            preparedStatement.setString(2, date[2]+"-"+date[1]+"-"+ date[0]);
            preparedStatement.setBoolean(3, customer.isGender());
            preparedStatement.setInt(4, customer.getCustomerType().getIdCustomerType());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Customer> findAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customers = new ArrayList<>();
        // Step 1: Establishing a Connection
        // Step 2:Create a statement using connection object
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id_customer");
                String name = rs.getString("name_customer");
                String birthday = rs.getString("birthday");
                boolean gender = rs.getBoolean("gender");
                CustomerType customer_type = customerTypeRepository.selectTypeNote(rs.getInt("id_customer_type"));
                customers.add(new Customer(id, name, customer_type, birthday, gender));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public List<Customer> searchCustomer(String name) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customers = new ArrayList<>();
        String query = "{CALL search_customer(?)}";
        // Step 1: Establishing a Connection
        try (
                Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, name);
            // Step 3: Execute the query or update query
            ResultSet rs = callableStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id_customer");
                String name_customer = rs.getString("name_customer");
                String birthday = rs.getString("birthday");
                boolean gender = rs.getBoolean("gender");
                CustomerType customer_type = customerTypeRepository.selectTypeNote(rs.getInt("id_customer_type"));
                customers.add(new Customer(id, name_customer, customer_type, birthday, gender));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public Customer findById(int id) {
        Customer customer = null;
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                String name = rs.getString("name_customer");
                String birthday = rs.getString("birthday");
                boolean gender = rs.getBoolean("gender");
                CustomerType customer_type = customerTypeRepository.selectTypeNote(rs.getInt("id_customer_type"));
                customer =new Customer(id, name, customer_type, birthday, gender);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    public void remove(int id) throws SQLException {
        try ( Connection connection = getConnection();
              PreparedStatement statement = connection.prepareStatement(DELETE_CUS_SQL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        }
    }

}
