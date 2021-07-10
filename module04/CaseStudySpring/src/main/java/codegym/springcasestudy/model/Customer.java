package codegym.springcasestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @ManyToOne
    @JoinColumn(name = "customerType_id")
    private CustomerType customerType;

    @NotBlank(message = "Name not blank")
    private String customerName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate customerBirthday;

    private String gender;

    @NotBlank(message = "Id card not blank")
    @Pattern(regexp = "^(\\d{9}|\\d{12})$", message = "Wrong format id card, 9 or 12 number")
    private String customerIdCard;

    @NotBlank(message = "Phone not blank")
    @Pattern(regexp = "^((090|091)+\\d{7})$", message = "Wrong format phone number")
    private String customerPhone;

    @NotBlank(message = "Email not blank")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{1,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Email invalid")
    private String customerEmail;

    @NotBlank(message = "Address not blank")
    private String customerAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    @NotBlank(message = "Customer code not blank")
    @Pattern(regexp = "^(KH-\\d{4})$", message = "Wrong format. KH-XXXX")
    @Column(unique = true)
    private String customerCode;

    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(LocalDate customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
