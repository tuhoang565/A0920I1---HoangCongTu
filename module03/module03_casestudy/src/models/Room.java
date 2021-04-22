package models;

public class Room extends Service {
    private String freeService;

    public Room() {
    }

    public Room(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople,
                String rentType, String freeService) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
