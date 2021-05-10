package dao;

import models.EducationDegree;

import java.sql.*;
import java.util.List;

public class EducationDegreeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL_EDUCATION_DEGREE = "select * from education_degree";
    private static final String SELECT_EDUCATION_DEGREE_BY_ID = "select * from education_degree where education_degree_id = ?";

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

    public List<EducationDegree> getAllEducationDegree(){
        Connection  connection = null;
        PreparedStatement statement = null;
        List<EducationDegree> educationDegreeList = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName =resultSet.getString("education_degree_name");
                educationDegreeList.add(new EducationDegree(educationDegreeId, educationDegreeName));
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
        return educationDegreeList;
    }

    public EducationDegree getEducationDegreeById(int educationDegreeId){
        Connection connection = null;
        PreparedStatement statement = null;
        EducationDegree educationDegree = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_EDUCATION_DEGREE_BY_ID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String educationDegreeName = resultSet.getString("education_degree_name");
                educationDegree = new EducationDegree(educationDegreeId, educationDegreeName);
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
        return educationDegree;
    }
}
