package controller;

import common.Validate;
import dao.ProductDAO;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
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
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> productList = productDAO.getAllProduct();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("product/listProduct.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException{

        String productName = request.getParameter("productName");
        int productPrice = Integer.parseInt(request.getParameter("productPrice"));
        int productDiscount = Integer.parseInt(request.getParameter("productDiscount"));
        int productExist = Integer.parseInt(request.getParameter("productExist"));
        Product product = new Product(productName, productPrice, productDiscount, productExist);
        productDAO.insertProduct(product);

        listProduct(request, response);

//        String messageName = Validate.validateName(productName);
//        String messagePrice = Validate.validatePrice(productPrice);
//        String messageStock = Validate.validateStock(productExist);
//
//        if(messageName == null && messagePrice == null && messageStock ==  null){
//            productDAO.insertProduct(product);
//            product = null;
//            listProduct(request, response);
//        }else{
//            List<Product> productList = productDAO.getAllProduct();
//            request.setAttribute("productList", productList);
//        request.setAttribute("product", product);
//        }


    }
}
