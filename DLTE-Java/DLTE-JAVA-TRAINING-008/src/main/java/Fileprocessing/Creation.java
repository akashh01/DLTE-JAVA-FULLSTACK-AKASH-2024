package Fileprocessing;

import java.io.File;
import java.io.IOException;

public class Creation {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\xxnlnnpa\\Documents\\DLTE-JAVA-FULLSTACK-AKASH-2024\\DLTE-Java\\DLTE-JAVA-TRAINING-008");
        System.out.println(file.isFile());
         System.out.println(file.isDirectory());
      System.out.println(file.exists());
       //System.out.println(file.getAbsolutePath());
       File file1=new File("Hello.doc");

        try {
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
}
}//C:\Users\xxnlnnpa\Documents\DLTE-JAVA-FULLSTACK-AKASH-2024\DLTE-Java\DLTE-JAVA-TRAINING-008