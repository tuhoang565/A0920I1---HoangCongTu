package dao;

import models.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String INSERT_SERVICES = "INSERT INTO service (service_id, service_name, service_area, service_cost," +
            " service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area" +
            ", number_of_floors) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_SERVICE = "select * from service";
    private static final String SELECT_SERVICE_BY_ID = "select * from service where service_id = ?";
    private static final String UPDATE_SERVICE = "update service set service_id = ?, service_name = ?, service_area = ?," +
            "service_area = ?, service_cost = ?, service_max_people = ?, rent_type_id = ?, service_type_id = ?, standard_room = ?," +
            "description_other_convenience = ?, pool_area = ?, number_of_floors = ?";
    private static final String DELETE_SERVICE = "delete * from service where service_id = ?";

    public ServiceDAO() {
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

    public void insert(Service service){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(INSERT_SERVICES);

            statement.setInt(1, service.getServiceId());
            statement.setString(2, service.getServiceName());
            statement.setInt(3, service.getServiceArea());
            statement.setDouble(4, service.getServiceCost());
            statement.setInt(5, service.getServiceMaxPeople());
            statement.setInt(6, service.getRentTypeId());
            statement.setInt(7, service.getServiceId());
            statement.setString(8, service.getStandardRoom());
            statement.setString(9, service.getDescriptionOtherConvenience());
            statement.setDouble(10, service.getPoolArea());
            statement.setInt(11, service.getNumberOfFloor());
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

    public List getAll(){
        List<Service> serviceList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloor = resultSet.getInt("number_of_floors");
                serviceList.add(new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId,
                 serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloor));
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
        return serviceList;
    }
}
