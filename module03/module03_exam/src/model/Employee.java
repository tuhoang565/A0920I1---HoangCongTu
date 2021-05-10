package model;

import java.time.LocalDate;

public class Employee {
    private int employeeId;
    private String employeeName;
    private LocalDate employeeBirthday;
    private String employeeAddress;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, LocalDate employeeBirthday, String employeeAddress) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeAddress = employeeAddress;
    }

    public Employee(String employeeName, LocalDate employeeBirthday, String employeeAddress) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeAddress = employeeAddress;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(LocalDate employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}
