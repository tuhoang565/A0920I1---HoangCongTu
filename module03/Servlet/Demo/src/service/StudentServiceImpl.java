package service;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static Map<String, Student> studentMap;

    public StudentServiceImpl(){
        if(studentMap != null){
            return;
        }
        studentMap = new HashMap<>();
        studentMap.put("1", new Student("1", "Hoang", 18, "Da Nang"));
        studentMap.put("2", new Student("2", "Quang", 18, "Quang Nam"));
        studentMap.put("3", new Student("3", "Thuy", 18, "Hue"));
        studentMap.put("4", new Student("4", "Anh", 18, "Da Nang"));
        studentMap.put("5", new Student("5", "Hiep", 18, "Quang Nam"));
    }

    @Override
    public Student getStudentById(String id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void saveStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public void updateStudent(Student student) {
        if(studentMap.get(student.getId()) !=  null){
            studentMap.put(student.getId(), student);
        }
    }

    @Override
    public void deleteStudentById(String id) {
        if(studentMap.get(id) != null){
            studentMap.remove(id);
        }
    }
}
