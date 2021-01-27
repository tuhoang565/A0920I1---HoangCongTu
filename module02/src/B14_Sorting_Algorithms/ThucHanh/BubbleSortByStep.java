package B14_Sorting_Algorithms.ThucHanh;



public class BubbleSortByStep {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 9, 11};
        System.out.println("\nBegin sort processing...");
        bubbleSortByStep(arr);
    }

    public static void bubbleSortByStep(int[] list){
        boolean needNextPass = true;
        for(int k = 1; k < list.length - k; k++){
            needNextPass = false;
            for(int i = 0; i < list.length - k; i++){
                if(list[i] > list[i + 1]){
                    System.out.println("Swap " + list[i] + " with " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }

            if(needNextPass = false){
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }

            System.out.println("list after the " + k + " sort: ");
            for(int j = 0; j < list.length; j++){
                System.out.println(list[j] + "\t");
            }
            System.out.println();
        }
    }
}
