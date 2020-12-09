package B4_Class_Object.Bai_Tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuadraticEquation qe = new QuadraticEquation();
        System.out.println("Enter value a: ");
        qe.a = scanner.nextDouble();
        System.out.println("Enter value b: ");
        qe.b = scanner.nextDouble();
        System.out.println("Enter value c: ");
        qe.c = scanner.nextDouble();


        if (qe.getDiscriminant() > 0) {
            System.out.println("Pt co 2 nghiem: ");
            System.out.println("Nghiem 1: " + qe.getRoot1());
            System.out.println("Nghiem 2: " + qe.getRoot2());
        } else if (qe.getDiscriminant() == 0) {
            System.out.println("Pt co nghiem kep x1 = x2: " + qe.getRoot3());
        }else {
            System.out.println("Pt vo nghiem");
        }
    }



    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;

    }

    public double getRoot1() {
        double r1;
        r1 = (-this.b + Math.pow(this.getDiscriminant(), 0.5)) / 2 * this.a;
        return r1;
    }

    public double getRoot2() {
        double r2;
        r2 = (-this.b - Math.pow(this.getDiscriminant(), 0.5)) / 2 * this.a;
        return r2;
    }

    public double getRoot3(){
        double r3;
        r3 = (-this.b)/2 * this.a;
        return r3;
    }

}
