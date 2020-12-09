package B3_Array_Method.Bai_Tap;

public class TimPhanTuNhoNhat {
    public static void main(String[] args) {
        int arr[] = {4, 6, 2, 9, 11};
        minValue(arr);

    }
    public static void minValue(int[] array){
        int min = array[0];
        for(int i = 0; i < array.length; i ++){
            if(array[i] < min){
                min = array[i];
            }
        }

        System.out.println("min value: " + min);
    }
}
