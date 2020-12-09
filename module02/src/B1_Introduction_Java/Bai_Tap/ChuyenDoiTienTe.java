package B1_Introduction_Java.Bai_Tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float rate = 23000f;
        System.out.println("Enter money(USD): ");
        float usd = scanner.nextFloat();
        float vnd = usd * rate;
        System.out.println("VND: " + vnd);
    }
}
