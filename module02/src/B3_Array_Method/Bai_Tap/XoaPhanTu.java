package B3_Array_Method.Bai_Tap;

import java.util.Scanner;

public class XoaPhanTu {
    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 6, 7, 3};
        deleteElement(arr);
    }
    public static void deleteElement(int[] array){
        int c, i;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value to delete: ");
        int n = scanner.nextInt();
        for(c = i = 0; i < array.length; i++){
            if(array[i] != n){
                array[c] = array[i];
                c++;
            }
        }
        for(i = 0; i < c; i++){
            System.out.println(array[i]);
        }
    }
}
