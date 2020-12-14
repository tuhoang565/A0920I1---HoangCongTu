package B3_Array_Method.Bai_Tap;


import java.util.Scanner;

public class ChenPhanTu {
    public static void main(String[] args) {
        int arr[] = new int[10];
        arr[0] = 1;
        arr[1] = 10;
        arr[2] = 4;
        arr[3] = 7;
        arr[4] = 9;
        insert(arr);

    }

    public static void insert(int arr[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value: ");
        int value = scanner.nextInt();
        System.out.println("Enter index: ");
        int index = scanner.nextInt();

        if(index < 0 || index > arr.length-1){
            System.out.println("Invalid index");
        }else {
            for(int i = arr.length - 1; i > index; i--){
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
        }

        for(int x: arr){
            System.out.print(x + " ");
        }
    }


}
