package B2_Loop.Bai_Tap;

public class SoNTNhoHon100 {
    public static void main(String[] args) {
        int N = 2;
        while (N < 100){
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if(N % i == 0){
                    check = false;
                    break;
                }

            }

            if(check){
                System.out.print(N + " ");
            }
            N++;
        }
    }
}
