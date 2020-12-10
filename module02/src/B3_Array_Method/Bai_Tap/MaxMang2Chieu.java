package B3_Array_Method.Bai_Tap;

public class MaxMang2Chieu {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 4},{3, 5, 7}, {4, 6, 1}};

        int max = arr[0][0];
        int indexI = 0;
        int indexJ = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(max < arr[i][j]){
                    max = arr[i][j];
                    indexI = i;
                    indexJ = j;
                }
            }
        }

        System.out.println(max);
        System.out.println("Tai vi tri: " + indexI + " " + indexJ);
    }
}
