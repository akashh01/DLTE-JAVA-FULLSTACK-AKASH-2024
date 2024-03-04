package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class MyBankDatabase <T> implements Activity<T>{
    ArrayList<T> bankDataBase;
    @Override
    public String createNewData(T object) {

       bankDataBase.add(object);
       return "data added";
        }

        //return " object not added ";

    public void writeTofile() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("Mybankdb");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bankDataBase);
        fileOutputStream.close();
        objectOutputStream.close();
    }
    public void readFromfile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("Mybankdb");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        bankDataBase= (ArrayList<T>) objectInputStream.readObject();
        int size=bankDataBase.size();
        for(int index=0;index<size;index++) {
            if (bankDataBase.get(index) != null) {
                System.out.println(bankDataBase.get(index).toString());
            }
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyBankDatabase<CreditCard> storeCardData= new MyBankDatabase<>();
        storeCardData.bankDataBase=new ArrayList<>(10);
        CreditCard creditCardOne=new CreditCard(878884155L,"Akash",new Date(2023,12,20),987,80000,1124);
        CreditCard creditCardTwo=new CreditCard(878884177L,"Amal",new Date(2023,12,13),987,80000,1124);
        storeCardData.createNewData(creditCardOne);
        storeCardData.createNewData(creditCardTwo);
       // System.out.println(storeCardData.bankDataBase[1].getCreditCardHolder());
        storeCardData.writeTofile();
        storeCardData.readFromfile();
    }




}
