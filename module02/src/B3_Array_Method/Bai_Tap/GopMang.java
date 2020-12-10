package B3_Array_Method.Bai_Tap;

public class GopMang {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {7, 8, 9};

        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        int newArr[] = new int[arr1Length + arr2Length];
        for(int i = 0; i < arr1Length; i++){
            newArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2Length; i++){
            newArr[arr1Length + i] = arr2[i];
        }

        for(int x : newArr){
            System.out.println(x);
        }
    }
}
