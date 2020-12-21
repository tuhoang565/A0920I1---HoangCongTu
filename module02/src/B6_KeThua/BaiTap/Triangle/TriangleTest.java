package B6_KeThua.BaiTap.Triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);

        triangle = new Triangle("red", true, 4.2, 3.2, 5.5);
        System.out.println(triangle);
    }
}
