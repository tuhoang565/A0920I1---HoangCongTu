package controllers;

import commons.Validate;
import dao.RentTypeDAO;
import dao.ServiceDAO;
import dao.ServiceTypeDAO;
import models.RentType;
import models.Service;
import models.ServiceType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    private ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAO();
    private RentTypeDAO rentTypeDAO = new RentTypeDAO();
    private ServiceDAO serviceDAO = new ServiceDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    insertService(request, response);
                    break;
            }
        } catch (Exception e) {
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
                default:
                    listService(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void insertService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceDAO serviceDAO = new ServiceDAO();

        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        RentType rentType = rentTypeDAO.getRentTypeById(Integer.parseInt(request.getParameter("rentType")));
        ServiceType serviceType = serviceTypeDAO.getServiceTypeById(Integer.parseInt(request.getParameter("serviceType")));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloor = Integer.parseInt(request.getParameter("numberOfFloor"));

        Service service = new Service(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType,
                serviceType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloor);


        String messageServiceName = Validate.validateServiceName(serviceName);
        String messageServiceMaxPeople = Validate.validatePositiveNumber(serviceMaxPeople);
        String messageNumberOfFloor = Validate.validatePositiveNumber(numberOfFloor);
        try {
            //        Validate thanh cong
            if (messageNumberOfFloor == null && messageServiceMaxPeople == null && messageServiceName == null) {
                serviceDAO.insert(service);
                service = null;
                listService(request, response);
//            Validate that bai
            } else {
                List<RentType> rentTypeList = rentTypeDAO.getAllRentType();
                List<ServiceType> serviceTypeList = serviceTypeDAO.getAllServiceType();
                List<Service> serviceList = serviceDAO.getAll();
                request.setAttribute("service", service);
                request.setAttribute("rentTypeList", rentTypeList);
                request.setAttribute("serviceTypeList", serviceTypeList);
                request.setAttribute("serviceList", serviceList);
                request.setAttribute("messageServiceName", messageServiceName);
                request.setAttribute("messageServiceMaxPeople", messageServiceMaxPeople);
                request.setAttribute("messageNumberOfFloor", messageNumberOfFloor);
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/service/create.jsp");
                try{
                    dispatcher.forward(request, response);
                }catch (ServletException e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypeList = rentTypeDAO.getAllRentType();
        List<ServiceType> serviceTypeList = serviceTypeDAO.getAllServiceType();
        List<Service> serviceList = serviceDAO.getAll();

        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("jsp/service/list.jsp").forward(request, response);
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypeList = rentTypeDAO.getAllRentType();
        List<ServiceType> serviceTypeList = serviceTypeDAO.getAllServiceType();
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.getRequestDispatcher("jsp/service/create.jsp").forward(request, response);
    }
}
