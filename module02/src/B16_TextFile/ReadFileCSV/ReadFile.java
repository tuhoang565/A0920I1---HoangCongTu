package B16_TextFile.ReadFileCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String line;
        try (BufferedReader br = new BufferedReader(
                new FileReader("D:\\A0920I1_Hoang_Cong_Tu\\module02\\src\\B16_TextFile\\ReadFileCSV\\Nation.csv"))) {

            while ((line = br.readLine()) != null) {

                // split by a comma separator
                String[] split = line.split(",");

                System.out.println("Country : " + split[5]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
