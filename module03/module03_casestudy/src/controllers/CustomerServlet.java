package controllers;

import dao.CRUDDao;
import dao.CustomerDAO;
import models.Customer;
import sun.security.krb5.internal.crypto.Crc32CksumType;

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
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    @Override
    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
            }
        } catch (SQLException | ParseException e) {
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
                    deleteCustomer(request, response);
                    break;
                case "search":
                    searchCustomer(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String string = request.getParameter("searchInput");
        CRUDDao crudDao = new CustomerDAO();
        Customer customer = crudDao.search(string);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("jsp/customer/search.jsp").forward(request, response);
    }


    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        CRUDDao crudDao = new CustomerDAO();
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        crudDao.delete(customerId);

        List<Customer> customerList = crudDao.getAll();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("customerId"));
        CRUDDao crudDao = new CustomerDAO();
        Customer existingCustomer = crudDao.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/customer/edit.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CRUDDao crudDao = new CustomerDAO();
        List<Customer> customerList = crudDao.getAll();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/customer/create.jsp").forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException, SQLException {
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        CRUDDao crudDao = new CustomerDAO();

        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String customerName = request.getParameter("customerName");
        Date customerBirthday = formatter1.parse(request.getParameter("customerBirthday"));
        String customerGender = request.getParameter("customerGender");
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        crudDao.update(new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard,
                customerPhone, customerEmail, customerAddress));
        response.sendRedirect("customers");
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        CRUDDao crudDao = new CustomerDAO();

//        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String customerName = request.getParameter("customerName");
        Date customerBirthday = formatter1.parse(request.getParameter("customerBirthday"));
        String customerGender = request.getParameter("customerGender");
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        crudDao.insert(new Customer(customerType, customerName, customerBirthday, customerGender, customerIdCard,
                customerPhone, customerEmail, customerAddress));
        request.getRequestDispatcher("jsp/customer/create.jsp").forward(request, response);
    }
}
