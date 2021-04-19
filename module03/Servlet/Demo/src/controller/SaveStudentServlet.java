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

@WebServlet(name = "SaveStudentServlet", urlPatterns = "/save")
public class SaveStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      Cach 1: dung Map

//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        int age = Integer.parseInt(request.getParameter("age"));
//        String address = request.getParameter("address");
//        Student student = new Student(id, name, age, address);
//        StudentService studentService = new StudentServiceImpl();
//        studentService.saveStudent(student);
//        response.sendRedirect("list");

//        Cach 2: dung JDBC
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        Student student = new Student(id, name, age, address);
        IStudentDAO studentDAO = new StudentDAOImpl();
//
//        studentDAO.insertStudent(student);

//        Dung StoreProcedure
        studentDAO.insertStudentStore(student);

        response.sendRedirect("list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cach 1:
//        request.getRequestDispatcher("student/create.jsp").forward(request, response);

//        Cach 2:
        request.getRequestDispatcher("student/create.jsp").forward(request, response);
    }
}
