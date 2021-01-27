package B13_Search_Algorithms;

import java.util.Scanner;

public class BinarySearch_Recursive {
    public static void main(String[] args) {
        int[] myArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(search(myArr, 5));

    }
    public static int search(int[] arr, int numberSearch){
        int upper = arr.length - 1;
        int lower = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number want to search: ");
        numberSearch = scanner.nextInt();

        while (upper >= lower){
            int middle = (upper + lower)/2;
            if(numberSearch == arr[middle]){
               return middle;
            }else if(numberSearch < arr[middle]){
                upper = middle - 1;

            }else {
                lower = middle + 1;

            }
        }
        return -1;
    }
}
