package controllers;

import dao.*;
import models.Division;
import models.EducationDegree;
import models.Employee;
import models.Position;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    private DivisionDAO divisionDAO;
    private PositionDAO positionDAO;
    private EducationDegreeDAO educationDegreeDAO;
    @Override
    public void init() {
        employeeDAO = new EmployeeDAO();
        divisionDAO = new DivisionDAO();
        positionDAO = new PositionDAO();
        educationDegreeDAO = new EducationDegreeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "view":
                    viewEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeDAO.getById(employeeId);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("jsp/employee/detail.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {

        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        LocalDate employeeBirthday = LocalDate.parse(request.getParameter("employeeBirthday"));
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAdress");
        Position position = positionDAO.getPositionById(Integer.parseInt(request.getParameter("positionId")));
        EducationDegree educationDegree = educationDegreeDAO.getEducationDegreeById(Integer.parseInt(request.getParameter("educationDegreeId")));
        Division division = divisionDAO.getDivisionById(Integer.parseInt(request.getParameter("divisionId")));
        String username = request.getParameter("username");
        employeeDAO.update(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone,
                employeeEmail, employeeAddress, position, educationDegree, division, username));
        response.sendRedirect("employees");
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        LocalDate employeeBirthday = LocalDate.parse(request.getParameter("employeeBirthday"));
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        Position position = positionDAO.getPositionById(Integer.parseInt(request.getParameter("positionId")));
        EducationDegree educationDegree = educationDegreeDAO.getEducationDegreeById(Integer.parseInt(request.getParameter("educationDegreeId")));
        Division division = divisionDAO.getDivisionById(Integer.parseInt(request.getParameter("divisionId")));
        String username = request.getParameter("username");

        employeeDAO.insert(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone,
                employeeEmail, employeeAddress, position, educationDegree, division, username));
        request.getRequestDispatcher("jsp/employee/create.jsp").forward(request, response);

    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeDAO.getAll();
        List<Division> divisionList = divisionDAO.getAllDivision();
        List<Position> positionList = positionDAO.getAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeDAO.getAllEducationDegree();
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("jsp/employee/list.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        employeeDAO.delete(employeeId);
        response.sendRedirect("employees");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee existingEmployee = employeeDAO.getById(employeeId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/employee/edit.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Division> divisionList = divisionDAO.getAllDivision();
        List<Position> positionList = positionDAO.getAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeDAO.getAllEducationDegree();
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);

        request.getRequestDispatcher("jsp/employee/create.jsp").forward(request, response);
    }
}
