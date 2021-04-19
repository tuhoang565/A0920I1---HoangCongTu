package dao.impl;

import dao.IStudentDAO;
import model.Student;
import utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    private static final String INSERT_STUDENT_SQL = "insert into student(id, name, age, address) values(?, ?, ?, ?)";
    private static final String SELECT_STUDENT_BY_ID = "select * from student where id = ?";
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String DELETE_USER_BY_ID = "delete from student where id = ?";
    private static final String UPDATE_USER = "update student set name = ?, age = ?, address = ? where id = ?";

    private static final String SELECT_STUDENT_BY_ID_STORE = "CALL getStudentById(?)";
    private static final String INSERT_STUDENT_STORE = "CALL insertStudent(?,?,?,?)";
    private static final String SELECT_ALL_STUDENT_STORE = "CALL getAllStudent()";
    private static final String DELETE_STUDENT_BY_ID_STORE = "CALL deleteStudent(?)";
    private static final String UPDATE_STUDENT_STORE = "CALL editStudent(?,?,?,?)";



    @Override
    public void insertStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionDB.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);

            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

    }

    @Override
    public Student getStudent(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Student student = null;

        try {
            connection = ConnectionDB.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                student = new Student(id, name, age, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Student> studentList = new ArrayList<>();
        try {
            connection = ConnectionDB.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                Student student = new Student(id, name, age, address);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }

    @Override
    public void updateStudentDAO(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionDB.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_USER);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteStudent(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionDB.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Student getStudentByIdStore(String id) {
        Student student = null;
        Connection connection = null;
        CallableStatement statement = null;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareCall(SELECT_STUDENT_BY_ID_STORE);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                student = new Student(id, name, age, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return student;
    }

        @Override
        public void insertStudentStore (Student student){
            Connection connection = null;
            CallableStatement statement = null;
            try {
                connection = ConnectionDB.getConnection();
                statement = connection.prepareCall(INSERT_STUDENT_STORE);
                statement.setString(1, student.getId());
                statement.setString(2, student.getName());
                statement.setInt(3, student.getAge());
                statement.setString(4, student.getAddress());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public List<Student> getAllStudentStore () {
            List<Student> studentList = new ArrayList<>();
            Connection connection = null;
            CallableStatement statement = null;
            try {
                connection = ConnectionDB.getConnection();
                statement = connection.prepareCall(SELECT_ALL_STUDENT_STORE);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String address = resultSet.getString("address");
                    Student student = new Student(id, name, age, address);
                    studentList.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return studentList;
        }

        @Override
        public void updateStudentStore (Student student){

        }

        @Override
        public void deleteStudentStore (String id){
            Connection connection = null;
            CallableStatement statement = null;
            try{
                connection = ConnectionDB.getConnection();
                statement = connection.prepareCall(DELETE_STUDENT_BY_ID_STORE);
                statement.setString(1, id);
                statement.executeUpdate();
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
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    @Override
    public void insertStudentTransaction() {
        Connection connection = null;
        PreparedStatement statement = null;
        Student student = null;
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("6", "Hue", 12, "Da Nang"));
//        studentList.add(new Student("6", "Hung", 22, "Da Nang"));

        try{
            connection = ConnectionDB.getConnection();
            statement = connection.prepareCall(INSERT_STUDENT_STORE);
            connection.setAutoCommit(false);

            for(Student student1 : studentList){
                statement.setString(1, student1.getId());
                statement.setString(2, student1.getName());
                statement.setInt(3, student1.getAge());
                statement.setString(4, student1.getAddress());
                statement.executeUpdate();
                System.out.println("Update success with id: " + student1.getId());
            }
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
