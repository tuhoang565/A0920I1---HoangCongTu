package models;

public class AttachService {
    private String attachServiceName;
    private int attachServiceUnit;
    private double attachServiceCost;

    public AttachService() {
    }

    public AttachService(String attachServiceName, int attachServiceUnit, double attachServiceCost) {
        this.attachServiceName = attachServiceName;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }
}
