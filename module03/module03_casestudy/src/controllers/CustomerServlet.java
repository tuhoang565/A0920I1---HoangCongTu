package controllers;

import commons.Validate;
import dao.CRUDDao;
import dao.CustomerDAO;
import dao.CustomerTypeDAO;
import dao.GenderDAO;
import models.Customer;
import models.CustomerType;
import models.Gender;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;
    private CustomerTypeDAO customerTypeDAO;
    private GenderDAO genderDAO;

    @Override
    public void init() {
        customerDAO = new CustomerDAO();
        customerTypeDAO = new CustomerTypeDAO();
        genderDAO = new GenderDAO();
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
                case "view":
                    viewCustomer(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        Customer customer = customerDAO.getById(customerId);
        CustomerType customerType = customerTypeDAO.selectCustomerType(customer.getCustomerId());
        request.setAttribute("customer", customer);
        request.setAttribute("customerType", customerType);
        request.getRequestDispatcher("jsp/customer/detail.jsp").forward(request, response);
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String string = request.getParameter("searchInput");
        CRUDDao crudDao = new CustomerDAO();
        List<Customer> customerList = crudDao.search(string);
        request.setAttribute("customerList", customerList);
        if(!customerList.isEmpty()) {
            List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomerType();
            List<Gender> genderList = genderDAO.selectAllGender();
            request.setAttribute("genderList", genderList);
            request.setAttribute("customerTypeList", customerTypeList);
            request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
        }else {
            response.sendRedirect("jsp/customer/search.jsp");
        }

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
        CustomerType existingCustomerType = customerTypeDAO.selectCustomerType(existingCustomer.getCustomerId());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/customer/edit.jsp");
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomerType();
        List<Gender> genderList = genderDAO.selectAllGender();
        request.setAttribute("genderList", genderList);
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("customer", existingCustomer);
        request.setAttribute("customerType", existingCustomerType);
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CRUDDao crudDao = new CustomerDAO();

        List<Customer> customerList = crudDao.getAll();
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomerType();
        List<Gender> genderList = genderDAO.selectAllGender();
        request.setAttribute("genderList", genderList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomerType();
        List<Gender> genderList = genderDAO.selectAllGender();
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("genderList", genderList);
        request.getRequestDispatcher("jsp/customer/create.jsp").forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException, SQLException {

        CRUDDao crudDao = new CustomerDAO();

        int customerId = Integer.parseInt(request.getParameter("customerId"));
        CustomerType customerType = customerTypeDAO.selectCustomerType(Integer.parseInt(request.getParameter("customerType")));
        String customerName = request.getParameter("customerName");
        LocalDate customerBirthday = LocalDate.parse(request.getParameter("customerBirthday"));
        Gender customerGender = genderDAO.selectGenderById(Integer.parseInt(request.getParameter("customerGender")));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard,
                customerPhone, customerEmail, customerAddress);
        crudDao.update(customer);

        request.setAttribute("customer", customer);
        request.getRequestDispatcher("jsp/customer/detail.jsp").forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        CRUDDao crudDao = new CustomerDAO();

//        int customerId = Integer.parseInt(request.getParameter("customerId"));
        CustomerType customerType = customerTypeDAO.selectCustomerType(Integer.parseInt(request.getParameter("cusType")));
        String customerName = request.getParameter("customerName");
        LocalDate customerBirthday = LocalDate.parse(request.getParameter("customerBirthday"));
        Gender customerGender = genderDAO.selectGenderById(Integer.parseInt(request.getParameter("customerGender")));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerType, customerName, customerBirthday, customerGender, customerIdCard,
                customerPhone, customerEmail, customerAddress);

//        Validate thành công
        String messagePhoneNumber = Validate.validatePhoneNumber(customerPhone);
        String messageIdCard = Validate.validateIdCard(customerIdCard);
        String messageEmail = Validate.validateEmail(customerEmail);
        String messageBirthday = Validate.validateBirthday(customerBirthday);
        try {
            if (messagePhoneNumber == null && messageBirthday == null && messageIdCard == null && messageEmail == null) {
                crudDao.insert(customer);
                customer = null;
                listCustomer(request, response);
            } else {//        Validate that bai

                List<Customer> customerList = customerDAO.getAll();
                List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomerType();
                List<Gender> genderList = genderDAO.selectAllGender();
                request.setAttribute("customer", customer);
                request.setAttribute("customerList", customerList);
                request.setAttribute("genderList", genderList);
                request.setAttribute("customerTypeList", customerTypeList);
                request.setAttribute("messagePhoneNumber", messagePhoneNumber);
                request.setAttribute("messageIdCard", messageIdCard);
                request.setAttribute("messageBirthday", messageBirthday);
                request.setAttribute("messageEmail", messageEmail);
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/customer/create.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
