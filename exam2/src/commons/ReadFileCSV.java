package commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static List<String> readFileCSV(String path){
        File file = new File(path);
        List<String> stringList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null){
                stringList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }
}
