package B6_KeThua.BaiTap.Triangle;

public class Triangle extends Shape {
    private double side1, side2, side3;

    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        //Tính diện tích tam giác khi biết 3 cạnh bằng công thức Heron
        return Math.pow((this.side1 + this.side2 + this.side3) * (this.side1 + this.side2 - this.side3)
                * (this.side2 + this.side3 - this.side1) * (this.side3 + this.side1 - this.side2), 0.25);
    }
    public double  getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString(){
        return "Triangle have side1: " + getSide1() + " side2: " + getSide2() + " side3: " + getSide3() + "and subclass "
                + super.toString() ;
    }
}
