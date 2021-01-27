package B16_TextFile.CopyFileText;

import java.io.*;
import java.nio.channels.FileChannel;

public class CopyFile {
    public static void main(String[] args) {
        File source = new File("D:\\A0920I1_Hoang_Cong_Tu\\module02\\src\\B16_TextFile\\CopyFileText\\sourceFile.txt");
        File destination = new File("D:\\A0920I1_Hoang_Cong_Tu\\module02\\src\\B16_TextFile\\CopyFileText\\destinationFile.txt");

        try {
            copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(File source, File destination) throws IOException {
        try(FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(destination);){

//
//            Su dung transferFrom cua FileChannel
//            FileChannel sourceChannel = inputStream.getChannel();
//            FileChannel destinationChannel = outputStream.getChannel();
//
//            destinationChannel.transferFrom(sourceChannel, 0,sourceChannel.size());

//            Su dung inputstream va outputstream
            byte[] buffer = new byte[1024];
            int lineLength;
            while ((lineLength = inputStream.read(buffer)) > 0){
                outputStream.write(buffer, 0, lineLength);
            }
        }
    }
}
