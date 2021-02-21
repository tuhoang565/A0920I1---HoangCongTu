package models;

public class Room extends Services {
    private ServicesPlus servicesPlus;

    public Room() {
    }

    public Room(String serviceName, int area, int cost, int numberOfPeople, String typeRent, String id, ServicesPlus servicesPlus) {
        super(serviceName, area, cost, numberOfPeople, typeRent, id);
        this.servicesPlus = servicesPlus;
    }

    @Override
    void showInfor() {
        System.out.println("Service Name: " + this.getServiceName() + " Area: " + this.getArea() + " Cost: " + this.getCost()
        + "Number of People: " + this.getNumberOfPeople() + "Type rent: " + this.getTypeRent() + " id: " + this.getId() +
        " Service Plus: " + servicesPlus.toString());
    }

    public String getInfo(){
        return this.getServiceName() + "," + this.getArea() + "," + this.getCost()
                + "," + this.getNumberOfPeople() + "," + this.getTypeRent() + "," + this.getId() +
                "," + this.servicesPlus.getNameServicesPlus() + "," + this.servicesPlus.getUnit() + "," + this.servicesPlus.getPrice();
    }
}
