package dao;

import models.RentType;
import models.ServiceType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentTypeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL_RENTTYPE = "select * from rent_type";
    private static final String SELECT_RENTTYPE_BY_ID = "select * from rent_type where rent_type_id = ?";

    public RentTypeDAO() {
    }

    public Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<RentType> getAllRentType(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<RentType> rentTypeList = new ArrayList<>();
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_RENTTYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                double rentTypeCost = resultSet.getDouble("rent_type_cost");
                rentTypeList.add(new RentType(rentTypeId, rentTypeName, rentTypeCost));
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
        return rentTypeList;
    }

    public RentType getRentTypeById(int rentTypeId){
        Connection  connection = null;
        PreparedStatement statement = null;
        RentType rentType = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_RENTTYPE_BY_ID);
            statement.setInt(1, rentTypeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String rentTypeName = resultSet.getString("rent_type_name");
                double rentTypeCost = resultSet.getDouble("rent_type_cost");
                rentType = new RentType(rentTypeId, rentTypeName, rentTypeCost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentType;
    }
}
