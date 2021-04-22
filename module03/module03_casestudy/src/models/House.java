package models;

public class House extends Service {
    private String standardRoom;
    private String otherConvenience;
    private int numberOfFloor;

    public House() {
    }

    public House(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople,
                 String rentType, String standardRoom, String otherConvenience, int numberOfFloor) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType);
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
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

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }


}
