package dao;

import model.Student;

import java.util.List;

public interface IStudentDAO {
    void insertStudent(Student student);
    void saveStudent(Student student);
    Student getStudent(String id);
    List<Student> getAllStudent();
    void updateStudentDAO(Student student);
    void deleteStudent(String id);

    Student getStudentByIdStore(String id);
    void insertStudentStore(Student student);
    List<Student> getAllStudentStore();
    void updateStudentStore(Student student);
    void deleteStudentStore(String id);

    void insertStudentTransaction();
}
