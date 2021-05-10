package controller;

import common.Validate;
import model.Customer;
import model.CustomerType;
import service.CustomerService;
import service.CustomerTypeService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeServiceImpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService;
    private CustomerTypeService customerTypeService;

    public void init() {
        customerService = new CustomerServiceImpl();
        customerTypeService = new CustomerTypeServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }
private void showCreate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    List<CustomerType> customerTypeList = customerTypeService.getAll();
    request.setAttribute("customerTypeList", customerTypeList);
    RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
    dispatcher.forward(request, response);
}
    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCus = customerService.getAll();
        List<CustomerType> customerTypeList = customerTypeService.getAll();
        request.setAttribute("listCus", listCus);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        try {
            customerService.deleteCus(idCustomer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listCustomer(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String customerName = request.getParameter("customerName");
        String messageName = Validate.validateCustomerName(customerName);
        String birthday = request.getParameter("birthday");
        String messageBirthday = Validate.validateBirthday(birthday);
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        CustomerType cusType = customerTypeService.getCusTypeById(Integer.parseInt(request.getParameter("cusType")));
        Customer customer = new Customer(customerName, cusType, birthday, gender);
        ;

        // thành công
        try {
            if (messageName == null && messageBirthday == null) {
                customerService.addCus(customer);
                customer = null;
            listCustomer(request,response);
            }
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }

        // validate thất bại
        List<CustomerType> customerTypeList = customerTypeService.getAll();
        List<Customer> listCus = customerService.getAll();
        request.setAttribute("customer", customer);
        request.setAttribute("messageName", messageName);
        request.setAttribute("messageBirthday", messageBirthday);
        request.setAttribute("listCus", listCus);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}