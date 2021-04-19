package controller;

import dao.IUserDAO;
import dao.UserDAOImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchUserServlet", urlPatterns = "/search")
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("search");
        IUserDAO userDAO = new UserDAOImpl();
        User user = userDAO.searchUser(country);
        request.setAttribute("user", user);
        request.getRequestDispatcher("user/search.jsp").forward(request, response);
    }
}
