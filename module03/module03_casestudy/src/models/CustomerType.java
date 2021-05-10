package models;

public class CustomerType {
    private int customerTypeId;
    private String customerTypeName;

    public CustomerType() {
    }

    public CustomerType(int customerTypeId, String customerType) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerType;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
