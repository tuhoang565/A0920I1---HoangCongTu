package B6_KeThua.BaiTap.Circle_Cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        this(1);
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return super.getArea() * height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height: " + getHeight() + " which is a subclass of " + super.toString();
    }
}
