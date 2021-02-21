package models;

public abstract class Services {
    private String serviceName, typeRent, id;
    int area, cost;
    int numberOfPeople;


    public Services() {
    }

    public Services(String serviceName, int area, int cost, int numberOfPeople, String typeRent, String id) {
        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.typeRent = typeRent;
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    abstract void showInfor();

    @Override
    public String toString() {
        return "Services{" +
                "serviceName='" + serviceName + '\'' +
                ", typeRent='" + typeRent + '\'' +
                ", id='" + id + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }
}
