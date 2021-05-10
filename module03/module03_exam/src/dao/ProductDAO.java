package dao;

import model.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_exam";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String INSERT_PRODUCT = "insert into product(product_name, product_price, product_discount, product_exist) values(?,?,?,?)";
    private static final String SELECT_ALL_PRODUCT = "select * from product";
    private static final String GET_PRODUCT_BY_ID = "select * from product where product_id = ?";

    public ProductDAO() {
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

    public void insertProduct(Product product) throws SQLException{

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT_PRODUCT);

           statement.setString(1, product.getProductName());
           statement.setInt(2, product.getProductPrice());
           statement.setInt(3, product.getProductDiscount());
           statement.setInt(4, product.getProductExist());
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

    public List getAllProduct() {
        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productPrice = resultSet.getInt("product_price");
                int productDiscount = resultSet.getInt("product_discount");
                int productExist = resultSet.getInt("product_exist");
                productList.add(new Product(productId, productName, productPrice, productDiscount, productExist));
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
        return productList;
    }

    public Product getProductById(int productId) {
        Product product = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String productName = resultSet.getString("product_name");
                int productPrice = resultSet.getInt("product_price");
                int productDiscount = resultSet.getInt("product_discount");
                int productExist = resultSet.getInt("product_exist");
                product = new Product(productId, productName, productPrice, productDiscount, productExist);
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
        return product;
    }
}
