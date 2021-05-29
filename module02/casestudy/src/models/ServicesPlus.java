package models;

public class ServicesPlus {
    private String nameServicesPlus;
    private int unit;
    private double price;

    public ServicesPlus() {
    }

    public ServicesPlus(String nameServicesPlus, int unit, double price) {
        this.nameServicesPlus = nameServicesPlus;
        this.unit = unit;
        this.price = price;
    }

    public String getNameServicesPlus() {
        return nameServicesPlus;
    }

    public void setNameServicesPlus(String nameServicesPlus) {
        this.nameServicesPlus = nameServicesPlus;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServicesPlus{" +
                "nameServicesPlus='" + nameServicesPlus + '\'' +
                ", unit=" + unit +
                ", price=" + price +
                '}';
    }
}
