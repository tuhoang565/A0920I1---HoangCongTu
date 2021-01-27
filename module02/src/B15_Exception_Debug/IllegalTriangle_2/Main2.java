package B15_Exception_Debug.IllegalTriangle_2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IllegalTriangleException2{
        Scanner scanner = new Scanner(System.in);
        Triangle2 triangle2 = new Triangle2();
        int side1, side2, side3;
        boolean done = false;
        System.out.println("Enter three sides: ");
        while (!done) {
            try {
                side1 = scanner.nextInt();
                side2 = scanner.nextInt();
                side3 = scanner.nextInt();
                triangle2 = new Triangle2(side1, side2, side3);
                done = true;
            } catch (IllegalTriangleException2 i) {
                System.out.println(i.getMessage());
                System.out.println("Enter three sides: ");

            }
        }
        System.out.println(triangle2.toString());
    }
}
