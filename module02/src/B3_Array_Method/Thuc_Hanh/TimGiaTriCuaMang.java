package B3_Array_Method.Thuc_Hanh;

import java.util.Scanner;

public class TimGiaTriCuaMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.println("Enter a value: ");
        String value = scanner.nextLine();

        boolean isCheck = false;
        for(int i = 0; i < students.length; i++){
            if(value.equals(students[i])){
                isCheck = true;
                break;
            }
        }

        if(isCheck){
            System.out.println("Found");
        }else {
            System.out.println("Not found");
        }
    }
}
