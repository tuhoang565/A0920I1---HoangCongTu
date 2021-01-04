package Models;

public class House extends Services{
    private String roomStandard;
    private String floor;
    private String otherService;

    public House() {
    }

    public House(String serviceName, double area, double cost, int numberOfPeople, String typeRent, String id, String roomStandard, String floor, String otherService) {
        super(serviceName, area, cost, numberOfPeople, typeRent, id);
        this.roomStandard = roomStandard;
        this.floor = floor;
        this.otherService = otherService;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    @Override
    void showInfor() {
        System.out.println("Service Name: " + this.getServiceName() + " Area: " + this.getArea() + " Cost: " + this.getCost()
                + "Number of People: " + this.getNumberOfPeople() + "Type rent: " + this.getTypeRent() + " id: " + this.getId() +
                "Room Standard: " + this.getRoomStandard() + "Floor: " + this.getFloor() + " Other Service: " + this.getOtherService());
    }
}
