package B14_Sorting_Algorithms.BaiTap;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] myArr = {3, 1, 5, 2};
        insertionSort(myArr);
        System.out.println(Arrays.toString(myArr));
    }

    public static int[] insertionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int currentElement = arr[i];
            int k;
            for(k = i - 1; k >= 0 && arr[k] > currentElement; k--){
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = currentElement;
        }

        return arr;
    }
}
