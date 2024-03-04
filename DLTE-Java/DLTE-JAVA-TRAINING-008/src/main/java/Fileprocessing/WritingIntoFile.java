package Fileprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class WritingIntoFile {
    public static void main(String[] args) throws IOException {
        File file=new File("testObject.doc");
        ///basic writing into file each time the file is rewritten
       FileOutputStream fileOutputStream=new FileOutputStream(file,true);
       //FileOutputStream fileOutputStream=new FileOutputStream("test.doc");


//        DataInputStream dataInputStream=new DataInputStream(System.in);
//        Byte myContent=dataInputStream.readByte();
//        fileOutputStream.write(myContent);
      //  DebitCard debitCard=new DebitCard(876567876567L,111,2121,new Date("2/11/2031"));
        int experience=11;float place=13.5F;
        String myExists=""+experience+""+place+"\n";
       // fileOutputStream.write(debitCard.toString().getBytes());
      //StringBuffer buffer=new StringBuffer();buffer.append(experience);buffer.append(place);
//        Scanner scanner=new Scanner(System.in);
//         String myContent=scanner.nextLine();
//        System.out.println(myContent.getBytes());
//         fileOutputStream.write(myContent.getBytes());
        //writing object to file
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        DebitCard debitCard=new DebitCard(876567876567L,111,2121,new Date("2/11/2031"));
        ArrayList<DebitCard> ab=new ArrayList<>();
        ab.add(debitCard);
        objectOutputStream.writeObject(ab);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
