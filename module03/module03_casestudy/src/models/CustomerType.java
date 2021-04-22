package models;

public class CustomerType {
    private int customerTypeId;
    private String customerType;

    public CustomerType() {
    }

    public CustomerType(int customerTypeId, String customerType) {
        this.customerTypeId = customerTypeId;
        this.customerType = customerType;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
