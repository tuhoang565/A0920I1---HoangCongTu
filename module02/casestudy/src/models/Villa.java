package models;

public class Villa extends Services {

    private String roomStandard;
    private int swimmingPoolArea;
    private int floor;
    private String otherService;

    public Villa() {
    }

    public Villa(String serviceName, int area, int cost, int numberOfPeople, String typeRent, String id,
                 String roomStandard, int swimmingPoolArea, int floor, String otherService) {
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

    public int getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(int swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
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

    public String getInfo(){
        return this.getServiceName() + "," + this.getArea() + "," + this.getCost() + "," + this.getNumberOfPeople() + ","
                + this.getTypeRent() + "," + this.getId() + "," + this.roomStandard + "," + this.swimmingPoolArea + ","
                + this.floor + "," + this.otherService;
    }


}
