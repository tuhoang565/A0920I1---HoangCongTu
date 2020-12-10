package B3_Array_Method.Bai_Tap;

public class TinhTongDuongCheo {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 4, 6}, {5, 6, 1, 0}, {2, 5, 5, 2}, {2, 2, 2, 2}};
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if(i == j || i + j == arr.length - 1){
                    sum += arr[i][j];
                }
            }
        }

        System.out.println("Sum: " + sum);
    }
}
