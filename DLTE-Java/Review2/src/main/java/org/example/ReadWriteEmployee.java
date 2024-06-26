package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ReadWriteEmployee {
    public ReadWriteEmployee() {
    }

    public void writeIntoFile(ArrayList<Object> emp){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\xxnlnnpa\\Documents\\DLTE-JAVA-FULLSTACK-AKASH-2024\\DLTE-Java\\Review2\\EmployeeDetails.doc");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            System.out.println(emp);
            objectOutputStream.writeObject(emp);
            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch (IOException expection){
            System.out.println(expection);
        }
    }
    public ArrayList<Object> readFromFile(){
        try{
            //Employee employee=new Employee();
            ArrayList<Object> arry=new ArrayList<>();
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\xxnlnnpa\\Documents\\DLTE-JAVA-FULLSTACK-AKASH-2024\\DLTE-Java\\Review2\\EmployeeDetails.doc");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            arry= (ArrayList<Object>) objectInputStream.readObject();
            // userList1.add((UserInformation) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();
            return arry;
        }
        catch (IOException | ClassNotFoundException  ioException){
            System.out.println(ioException);
        }
        return null;
    }
    public void writeIntoFileAddress(HashMap<Integer,Object> address,String type){
        try {
            String filepath;
            if(type.equals("temporary")){
                filepath="C:\\Users\\xxnlnnpa\\Documents\\DLTE-JAVA-FULLSTACK-AKASH-2024\\DLTE-Java\\Review2\\TemporaryAddressDetails.doc";
            }
            else{
                filepath="C:\\Users\\xxnlnnpa\\Documents\\DLTE-JAVA-FULLSTACK-AKASH-2024\\DLTE-Java\\Review2\\PermenantAddressDetails.doc";
            }
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            System.out.println(address);
            objectOutputStream.writeObject(address);
            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch (IOException expection){
            System.out.println(expection);
        }
    }
    public HashMap<Integer,Object> readFromFileAddress(String type){
        try{
            String filepath;
            if(type.equals("temporary")){
                filepath="C:\\Users\\xxnlnnpa\\Documents\\DLTE-JAVA-FULLSTACK-AKASH-2024\\DLTE-Java\\Review2\\TemporaryAddressDetails.doc";
            }
            else{
                filepath="C:\\Users\\xxnlnnpa\\Documents\\DLTE-JAVA-FULLSTACK-AKASH-2024\\DLTE-Java\\Review2\\PermenantAddressDetails.doc";
            }
            //Employee employee=new Employee();
            HashMap<Integer,Object> arry=new HashMap<>();
            FileInputStream fileInputStream=new FileInputStream(filepath);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            arry= (HashMap<Integer, Object>) objectInputStream.readObject();
            // userList1.add((UserInformation) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();
           // System.out.println(arry.size());
            return arry;
        }
        catch (IOException | ClassNotFoundException  ioException){
            System.out.println(ioException);
        }
        return null;
    }

}
