package Models;

public class Room extends Services {
    private String freeServices;
    private ServicesPlus servicesPlus;
    public Room() {
    }


    public Room(String serviceName, double area, double cost, int numberOfPeople, String typeRent, String id, String freeServices, ServicesPlus servicesPlus) {
        super(serviceName, area, cost, numberOfPeople, typeRent, id);
        this.freeServices = freeServices;
        this.servicesPlus = servicesPlus;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    public ServicesPlus getServicesPlus() {
        return servicesPlus;
    }

    public void setServicesPlus(ServicesPlus servicesPlus) {
        this.servicesPlus = servicesPlus;
    }

    @Override
    void showInfor() {
        System.out.println("Service Name: " + this.getServiceName() + " Area: " + this.getArea() + " Cost: " + this.getCost()
        + "Number of People: " + this.getNumberOfPeople() + "Type rent: " + this.getTypeRent() + " id: " + this.getId() +
        "Free Service: " + this.getFreeServices() + " Service Plus: " + this.getServicesPlus().getNameServicesPlus());
    }
}
