package B2_Loop.Bai_Tap;

import java.util.Scanner;

public class HienThi20SoNguyenTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        int count = 0;
        int n = 2;

        while (count < number) {

            boolean check = true;
            if (n == 2) {
                check = true;
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        check = false;
                        break;
                    }
                }

            }

            if(check){
                count++;
                n++;
                System.out.print(n + " ");
            }
        }
    }
}
