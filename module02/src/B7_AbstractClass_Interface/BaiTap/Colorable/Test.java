package B7_AbstractClass_Interface.BaiTap.Colorable;

public class Test {
    public static void main(String[] args) {
        Shape s = new Square();
        Square square = (Square) s;
        square.howToColor();
    }
}
