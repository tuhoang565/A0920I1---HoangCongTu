package codegym.springcasestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate contractStartDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate contractEndDate;

    @Min(value = 1, message = "Deposit > 0")
    private double contractDeposit;

    @Min(value = 1, message = "Total money > 0")
    private double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;

    public Contract() {
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
