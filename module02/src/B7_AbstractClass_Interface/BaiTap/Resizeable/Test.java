package B7_AbstractClass_Interface.BaiTap.Resizeable;

public class Test {
    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        System.out.println("Area: " + c1.getArea());
        c1.resize(0.5);
        System.out.println("new area circle: " + c1.getArea());

        Rectangle rectangle = new Rectangle(2, 3);
        System.out.println("Area: " + rectangle.getArea());
        rectangle.resize(10);
        System.out.println("new area rectangle: " + rectangle.getArea());

        Square square = new Square(3);
        System.out.println("Area: " + square.getArea());
        square.resize(10);
        System.out.println("new area square: " + square.getArea());
    }
}
