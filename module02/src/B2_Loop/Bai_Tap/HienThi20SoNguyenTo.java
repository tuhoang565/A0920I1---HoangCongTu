package B2_Loop.Bai_Tap;

import java.util.Scanner;

public class HienThi20SoNguyenTo {


    public static void main(String[] args) {
        int countPrime = 0;
        int n = 2;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = sc.nextInt();

        while(countPrime < number){
            if(checkPrime(n)){
                System.out.print(n + " ");
                countPrime++;
            }
            n++;
        }

    }
    public static boolean checkPrime(int n){
       boolean check = true;
       if(n < 2){
           check = false;
       }else{
           for (int i = 2; i <= Math.sqrt(n); i++){
               if(n % i == 0){
                   check = false;
                   break;
               }
           }
       }
       return check;
    }
}
