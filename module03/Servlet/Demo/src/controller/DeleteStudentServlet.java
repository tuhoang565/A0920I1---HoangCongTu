package controller;

import dao.IStudentDAO;
import dao.impl.StudentDAOImpl;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteStudentServlet", urlPatterns = "/delete")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cach 1

//        String id = request.getParameter("id");
//        StudentService studentService = new StudentServiceImpl();
//        studentService.deleteStudentById(id);
//        response.sendRedirect("list");

//        Cach 2: JDBC
        String id = request.getParameter("id");
        IStudentDAO studentDAO = new StudentDAOImpl();
//        studentDAO.deleteStudent(id);

//        Dung StoreProcedure
        studentDAO.deleteStudentStore(id);
        response.sendRedirect("list");
    }
}
