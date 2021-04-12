package dao.impl;

import dao.IStudentDAO;
import model.Student;
import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    private static final String INSERT_STUDENT_SQL = "insert into student(id, name, age, address) values(?, ?, ?, ?)";
    private static final String SELECT_STUDENT_BY_ID = "select * from student where id = ?";
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String DELETE_USER_BY_ID = "delete from student where id = ?";
    private static final String UPDATE_USER = "update student set name = ?, age = ?, address = ?, where id = ?";


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
    public Student getStudent(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Student student = null;

        try {
            connection = ConnectionDB.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            id = resultSet.getString("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String address = resultSet.getString("address");
            student = new Student(id, name, age, address);
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

            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getAddress());

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
        }finally {
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
}
