package B3_Array_Method.Bai_Tap;

import java.util.Scanner;

public class DemKiTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "Hello Tu, how are you?";

        System.out.println("Enter char want to count: ");
        String s = scanner.nextLine();

        int count = 0;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String a = Character.toString(ch);
            if(s.equals(a)){
                count++;
            }
        }

        System.out.println("So lan xuat hien: " + count);
    }
}
