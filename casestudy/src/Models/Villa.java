package Models;

public class Villa extends Services {

    private String roomStandard;
    private String swimmingPoolArea;
    private String floor;
    private String otherService;

    public Villa() {
    }

    public Villa(String serviceName, double area, double cost, int numberOfPeople, String typeRent, String id,
                 String roomStandard, String swimmingPoolArea, String floor, String otherService) {
        super(serviceName, area, cost, numberOfPeople, typeRent, id);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.floor = floor;
        this.otherService = otherService;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(String swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
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
                "Room Standard: " + this.getRoomStandard() + " Swimming Pool Area: " + this.getSwimmingPoolArea()
                + "Floor: " + this.getFloor() + " Other Service: " + this.getOtherService());
    }
}
