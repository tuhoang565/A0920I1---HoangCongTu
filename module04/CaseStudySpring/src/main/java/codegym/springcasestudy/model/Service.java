package codegym.springcasestudy.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @NotEmpty(message = "Customer code not empty")
    @Pattern(regexp = "^(DV-\\d{4})$", message = "Wrong format. DV-XXXX")
    @Column(unique = true)
    private String serviceCode;

    @NotEmpty(message = "Name not empty")
    private String serviceName;

    @Min(value = 1, message = "Area > 0")
    private int serviceArea;

    @Min(value = 1, message = "Cost > 0")
    private double serviceCost;

    @Min(value = 1, message = "People > 0")
    private int serviceMaxPeople;

    @ManyToOne
    @JoinColumn(name = "rentType_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "serviceType_id")
    private ServiceType serviceType;


    private String standardRoom;

    private String descriptionOtherConvenience;

    @Min(value = 1, message = "Pool area > 0")
    private double poolArea;

    @Min(value = 1, message = "Floor > 0")
    private int numberOfFloor;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Service() {
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
