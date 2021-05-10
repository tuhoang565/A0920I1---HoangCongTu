package dao;

import models.Division;
import models.EducationDegree;

import java.sql.*;
import java.util.List;

public class DivisionDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL_DIVISION = "select * from division";
    private static final String SELECT_DIVISION_BY_ID = "select * from division where division_id = ?";

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

    public List<Division> getAllDivision(){
        List<Division> divisionList = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                divisionList.add(new Division(divisionId, divisionName));
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
        return divisionList;
    }

    public Division getDivisionById(int divisionId){
        Connection connection = null;
        PreparedStatement statement = null;
        Division division = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_DIVISION_BY_ID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String divisionName = resultSet.getString("division_name");
                division = new Division(divisionId, divisionName);
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
        return division;
    }
}
