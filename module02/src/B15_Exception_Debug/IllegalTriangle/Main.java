package B15_Exception_Debug.IllegalTriangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);

        Triangle triangle = new Triangle();
        boolean done = false;
        int side1, side2, side3;

        System.out.println("Enter three sides: ");
        while (!done){
            try{
                side1 = scanner.nextInt();
                side2 = scanner.nextInt();
                side3 = scanner.nextInt();
                triangle = new Triangle(side1, side2, side3);
                done = true;
            }catch (IllegalTriangleException e){
                System.out.println(e.getMessage());
                System.out.println("Enter three sides: ");
                scanner.nextLine();
            }
        }

        System.out.println(triangle.toString());
    }
}
