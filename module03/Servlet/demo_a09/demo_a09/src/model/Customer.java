package model;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private CustomerType customerType;
    private String birthday;
    private boolean gender;

    public Customer(String nameCustomer, CustomerType customerType, String birthday, boolean gender) {
        this.nameCustomer = nameCustomer;
        this.customerType = customerType;
        this.birthday = birthday;
        this.gender = gender;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }


    public Customer() {
    }

    public Customer(int idCustomer, String nameCustomer, CustomerType customerType, String birthday, boolean gender) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.customerType = customerType;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Customer(CustomerType customerType, String birthday, boolean gender) {
        this.customerType = customerType;
        this.birthday = birthday;
        this.gender = gender;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
