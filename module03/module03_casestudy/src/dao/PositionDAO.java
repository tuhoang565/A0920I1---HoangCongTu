package dao;

import models.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL_POSITION = "select * from positionn";
    private static final String SELECT_POSITION_BY_ID = "select * from positionn where position_id = ?";

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

    public List<Position> getAllPosition(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Position> positionList = new ArrayList<>();
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_POSITION);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                positionList.add(new Position(positionId, positionName));
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
        return positionList;
    }

    public Position getPositionById(int positionId){
        Connection connection = null;
        PreparedStatement statement = null;
        Position position = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_POSITION_BY_ID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String positionName = resultSet.getString("position_name");
                position = new Position(positionId, positionName);
            }
        } catch (SQLException e) {

        }
        return position;
    }
}
