package dao;

import models.ServiceType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL_SERVICETYPE = "select * from service_type";
    private static final String SELECT_SERVICETYPE_BY_ID = "select * from service_type where service_type_id = ?";

    public ServiceTypeDAO() {
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

    public List<ServiceType> getAllServiceType(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_SERVICETYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(serviceTypeId, serviceTypeName));
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
        return serviceTypeList;
    }

    public ServiceType getServiceTypeById(int serviceTypeId){
        Connection  connection = null;
        PreparedStatement statement = null;
        ServiceType serviceType = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_SERVICETYPE_BY_ID);
            statement.setInt(1, serviceTypeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceType = new ServiceType(serviceTypeId, serviceTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceType;
    }
}
