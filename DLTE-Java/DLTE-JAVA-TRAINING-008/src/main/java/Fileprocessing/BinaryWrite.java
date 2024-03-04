package Fileprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.zip.DeflaterOutputStream;

public class BinaryWrite {
    public static void main(String[] args) throws IOException {


        File file = new File("debits.doc");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(fileOutputStream);
        DebitCard debitCard = new DebitCard(876567876567L, 111, 2121, new Date("2/11/2031"));
        deflaterOutputStream.write(debitCard.toString().getBytes());
        deflaterOutputStream.close();
        fileOutputStream.close();
    }
}
