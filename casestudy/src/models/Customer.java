package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private String idCustomer;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services services;

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String idCustomer, String phoneNumber, String email,
                    String typeCustomer, String address, Services services) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCustomer = idCustomer;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.services = services;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void showInfor() {
        System.out.println("Name: " + this.getName() + " Birthday: " + this.getBirthday() + " Gender: " + this.getGender()
                + " Id Customer: " + this.getIdCustomer() + " Phone number: " + this.getPhoneNumber() + " Email: " + this.getEmail()
                + " Type Customer: " + this.getTypeCustomer() + " Address: " + this.getAddress() + this.services.toString());
    }

    public String getInfor() {
        return this.getName() + "," + this.getBirthday() + "," + this.getGender() + "," + this.getIdCustomer() + "," + this.getPhoneNumber() + ","
                + this.getEmail() + "," + this.getTypeCustomer() + "," + this.getAddress() + "," + services.toString();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                ", services=" + services +
                '}';
    }

    public int compareTo(Customer customer) {
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        if(this.name.equals(customer.getName())) {
            try {
                return f.parse(this.birthday).compareTo(f.parse(customer.getBirthday())) > 0 ? -1 : 1;
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }else {
            return this.name.compareTo(customer.getName());
        }
    }
}
