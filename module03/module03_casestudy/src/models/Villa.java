package models;

public class Villa extends Service {
    private String standardRoom;
    private String otherConvenience;
    private double poolArea;
    private int numberOfFloor;

    public Villa() {
    }

    public Villa(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople,
                 String rentType, String standardRoom, String otherConvenience, double poolArea, int numberOfFloor) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType);
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
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
}
