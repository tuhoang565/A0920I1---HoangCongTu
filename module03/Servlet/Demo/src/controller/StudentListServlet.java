package controller;

import dao.IStudentDAO;
import dao.impl.StudentDAOImpl;
import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentListServlet", urlPatterns = "/list")
public class StudentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      Cach 1: dung Maps

//        StudentService studentService = new StudentServiceImpl();
//        List<Student> studentList = studentService.getAll();
//        request.setAttribute("students", studentList);
//        request.getRequestDispatcher("student/list.jsp").forward(request, response);

//        Cach 2: dung JDBC
        IStudentDAO studentService = new StudentDAOImpl();
        List<Student> studentList = studentService.getAllStudent();
        request.setAttribute("students", studentList);
        request.getRequestDispatcher("student/list.jsp").forward(request, response);
    }
}
