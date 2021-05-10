package dao;

import models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module03_furama";
    private String jdbcUsername = "user";
    private String jdbcPassword = "123456";

    private PositionDAO positionDAO = new PositionDAO();
    private DivisionDAO divisionDAO = new DivisionDAO();
    private EducationDegreeDAO educationDegreeDAO = new EducationDegreeDAO();

    private static final String INSERT_EMPLOYEE = "insert into employee(employee_name, employee_birthday," +
            "employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id," +
            "division_id, username) values (?,?,?,?,?,?,?,?,?,?,?,)";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?";
    private static final String UPDATE_EMPLOYEE = "update employee set employee_id=?, employee_name=?, employee_birthday=?," +
            "employee_id_card=?, employee_salary=?, employee_phone=?, employee_email=?, employee_address=?, position_id=?, " +
            "education_degree_id=?,division_id=?, username=?";
    private static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?";

    public EmployeeDAO() {
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

    public void insert(Employee employee){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(INSERT_EMPLOYEE);

            LocalDate myDate = employee.getEmployeeBirthday();

            statement.setString(1, employee.getEmployeeName());
            statement.setDate(2, Date.valueOf(myDate));
            statement.setString(3, employee.getEmployeeIdCard());
            statement.setDouble(4, employee.getEmployeeSalary());
            statement.setString(5, employee.getEmployeePhone());
            statement.setString(6, employee.getEmployeeEmail());
            statement.setString(7, employee.getEmployeeAddress());
            statement.setInt(8, employee.getPosition().getPositionId());
            statement.setInt(9, employee.getEducationDegree().getEducationDegreeId());
            statement.setInt(10, employee.getDivision().getDivisionId());
            statement.setString(11, employee.getUsername());

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
        Connection connection = null;
        PreparedStatement statement = null;
        List<Employee> employeeList = new ArrayList<>();
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                java.sql.Date input = resultSet.getDate("employee_birthday");
                LocalDate date = input.toLocalDate();

                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                LocalDate employeeBirthday = date;
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                Position position = positionDAO.getPositionById(resultSet.getInt("position_id"));
                EducationDegree educationDegree = educationDegreeDAO.getEducationDegreeById(resultSet.getInt("education_degree_id"));
                Division division = divisionDAO.getDivisionById(resultSet.getInt("division_id"));
                String username = resultSet.getString("username");

                employeeList.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, position, educationDegree, division, username));
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
        return employeeList;
    }

    public Employee getById(int employeeId){
        Employee employee = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){

                String employeeName = resultSet.getString("employee_name");
                LocalDate employeeBirthday = resultSet.getDate("employee_birthday").toLocalDate();
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                Position position = positionDAO.getPositionById(resultSet.getInt("position_id"));
                EducationDegree educationDegree = educationDegreeDAO.getEducationDegreeById(resultSet.getInt("education_degree_id"));
                Division division = divisionDAO.getDivisionById(resultSet.getInt("division_id"));
                String username = resultSet.getString("username");
                employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone,
                        employeeEmail, employeeAddress, position, educationDegree, division, username);
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
        return employee;
    }

    public void delete(int serviceId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection =  getConnection();
            statement = connection.prepareStatement(DELETE_EMPLOYEE);
            statement.setInt(1, serviceId);
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

    public void update(Employee employee) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(UPDATE_EMPLOYEE);
            statement.setInt(1, employee.getEmployeeId());
            statement.setString(2, employee.getEmployeeName());
            statement.setDate(3, Date.valueOf(employee.getEmployeeBirthday()));
            statement.setString(4, employee.getEmployeeIdCard());
            statement.setDouble(5, employee.getEmployeeSalary());
            statement.setString(6, employee.getEmployeePhone());
            statement.setString(7, employee.getEmployeeEmail());
            statement.setString(8, employee.getEmployeeAddress());
            statement.setInt(9, employee.getPosition().getPositionId());
            statement.setInt(10, employee.getEducationDegree().getEducationDegreeId());
            statement.setInt(11, employee.getDivision().getDivisionId());
            statement.setString(12, employee.getUsername());
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
