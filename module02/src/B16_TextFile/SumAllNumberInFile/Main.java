package B16_TextFile.SumAllNumberInFile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String path = "D:\\A0920I1_Hoang_Cong_Tu\\module02\\src\\B16_TextFile\\SumAllNumberInFile\\numbers.txt";

        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);
    }
}
