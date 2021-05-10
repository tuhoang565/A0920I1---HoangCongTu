package model;

import java.time.LocalDate;

public class ManageOrder {
    private int manageOrderId;
    private String payment;
    private Customer customer;
    private Employee employee;
    private Product product;
    private LocalDate orderDate;
    private LocalDate diliverDate;
    private String diliverAddress;


    public ManageOrder() {
    }

    public ManageOrder(int manageOrderId, String payment, Customer customer, Employee employee, Product product,
                       LocalDate orderDate, LocalDate diliverDate, String diliverAddress) {
        this.manageOrderId = manageOrderId;
        this.payment = payment;
        this.customer = customer;
        this.employee = employee;
        this.product = product;
        this.orderDate = orderDate;
        this.diliverDate = diliverDate;
        this.diliverAddress = diliverAddress;
    }

    public ManageOrder(String payment, Customer customer, Employee employee, Product product, LocalDate orderDate,
                       LocalDate diliverDate, String diliverAddress) {
        this.payment = payment;
        this.customer = customer;
        this.employee = employee;
        this.product = product;
        this.orderDate = orderDate;
        this.diliverDate = diliverDate;
        this.diliverAddress = diliverAddress;
    }

    public int getManageOrderId() {
        return manageOrderId;
    }

    public void setManageOrderId(int manageOrderId) {
        this.manageOrderId = manageOrderId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDiliverDate() {
        return diliverDate;
    }

    public void setDiliverDate(LocalDate diliverDate) {
        this.diliverDate = diliverDate;
    }

    public String getDiliverAddress() {
        return diliverAddress;
    }

    public void setDiliverAddress(String diliverAddress) {
        this.diliverAddress = diliverAddress;
    }
}
