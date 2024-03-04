package Fileprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadingFromFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file=new File("C:\\Users\\xxnlnnpa\\Documents\\DLTE-JAVA-FULLSTACK-AKASH-2024\\DLTE-Java\\DLTE-JAVA-TRAINING-008\\testObject.doc");
        FileInputStream fileInputStream=new FileInputStream(file);
//        byte[] current=new byte[fileInputStream.available()];
//        fileInputStream.read(current);
//        String collectedData=new String(current);
//        System.out.println("File contains following content\n"+collectedData);

        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        ArrayList<DebitCard> db=new ArrayList<>();
        //DebitCard debitCard=(DebitCard) objectInputStream.readObject();
           db= (ArrayList<DebitCard>) objectInputStream.readObject();
        System.out.println(db.get(0).getDebitCardCvv());

        objectInputStream.close();
        fileInputStream.close();
    }


}
