package dao;

import model.Student;

import java.util.List;

public interface IStudentDAO {
    void insertStudent(Student student);
    Student getStudent(String id);
    List<Student> getAllStudent();
    void updateStudentDAO(Student student);
    void deleteStudent(String id);
}
