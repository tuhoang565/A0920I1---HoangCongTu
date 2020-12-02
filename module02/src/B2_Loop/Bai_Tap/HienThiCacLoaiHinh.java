package B2_Loop.Bai_Tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice");
        choice = sc.nextInt();

        while(choice != 0){
            switch (choice){
                case 1:
                    System.out.println("* * * * * * *");
                    System.out.println("* * * * * * *");
                    System.out.println("* * * * * * *");
                    System.out.println("* * * * * * *");
                case 2:
                    System.out.println("1. Top-left: ");
                    System.out.println("2. Top-right: ");
                    System.out.println("3. Bottom-left: ");
                    System.out.println("4. Bottom-right: ");
                    System.out.println("Enter your choice");
                    int choice_2 = sc.nextInt();
                    switch (choice_2){
                        case 1:
                            for(int i=1; i<=5; i++){
                                for(int j=1; j<i; j++){
                                    System.out.print("*");
                                }
                                System.out.println();
                            }
                    }

            }
        }
    }
}
