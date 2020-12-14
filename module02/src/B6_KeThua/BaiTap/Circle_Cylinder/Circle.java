package B6_KeThua.BaiTap.Circle_Cylinder;

public class Circle {
    private String color;
    private double radius;

    public Circle() {
        this("red", 1);
    }

    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public String toString(){
        return "A circle with color of " + getColor() + " and radius " + getRadius();
    }

}
