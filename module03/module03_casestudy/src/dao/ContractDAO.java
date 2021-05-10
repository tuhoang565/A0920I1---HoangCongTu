package dao;

import models.Contract;
import models.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private static final String INSERT_CONTRACT = "insert into contract(contract_id, contract_start_date, contract_end_date," +
            "contract_deposit, contract_total_money, employee_id, customer_id, service_id) values(?,?,?,?,?,?,?,?)";

    public ContractDAO() {
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

    public void insert(Contract contract){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(INSERT_CONTRACT);

            java.util.Date startDate = contract.getContractStartDate();
            java.util.Date endDate = contract.getContractEndDate();
            java.sql.Date contractStartDate = new java.sql.Date(startDate.getTime());
            java.sql.Date contractEndDate = new java.sql.Date(endDate.getTime());


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
}
