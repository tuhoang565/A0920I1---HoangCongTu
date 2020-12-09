package B3_Array_Method.Thuc_Hanh;

import java.util.Scanner;

public class TimGiaTriLonNhat {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 9, 2};
        int max = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }

        System.out.println("Max number: " + max);

    }
}
