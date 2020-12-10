package B3_Array_Method.Bai_Tap;

import java.util.Scanner;

public class TinhTongCot {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 4, 6}, {5, 6, 1, 0}, {2, 5, 5, 2}, {2,2,2,2}};
        int sum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter column want to sum: ");
        int column = scanner.nextInt();

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if(j == column){
                    sum += arr[i][j];
                }
            }
        }

        System.out.println("Sum: " + sum);
    }
}
