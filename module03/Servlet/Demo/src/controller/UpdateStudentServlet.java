package controller;

import dao.IStudentDAO;
import dao.impl.StudentDAOImpl;
import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateStudentServlet", urlPatterns = "/update")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cach 1:

//        String id = (request.getParameter("id"));
//        String name = request.getParameter("name");
//        int age = Integer.parseInt(request.getParameter("age"));
//        String address = request.getParameter("address");
//
//        Student student = new Student(id, name, age, address);
//        StudentService studentService = new StudentServiceImpl();
//        studentService.updateStudent(student);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("student/update.jsp");
//        dispatcher.forward(request, response);
//        response.sendRedirect("list");

//        Cach 2: JDBC
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        Student student = new Student(id, name, age, address);
        IStudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.updateStudentDAO(student);
        response.sendRedirect("list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cach 1:

//        String id = request.getParameter("id");
//        StudentService studentService = new StudentServiceImpl();
//        Student existingStudent = studentService.getStudentById(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("student/update.jsp");
//        request.setAttribute("student", existingStudent);
//        dispatcher.forward(request, response);

//        Cach 2: JDBC
        String id = request.getParameter("id");
        IStudentDAO studentDAO = new StudentDAOImpl();
        Student existingStudent = studentDAO.getStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/update.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);
    }
}
