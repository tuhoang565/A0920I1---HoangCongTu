package B3_Array_Method.Thuc_Hanh;

public class DaoNguocPhanTuCuaMang {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7};
        for(int i = 0; i < arr.length/2; i++){
            int j = arr.length - 1 - i;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for (int x : arr){
            System.out.print(x + " ");
        }
    }
}
