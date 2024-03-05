package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ReadWriteEmployee {
    public ReadWriteEmployee() {
    }

    public void writeIntoFile(ArrayList<Object> emp){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("EmployeeDetails.doc",true);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(emp);
            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch (IOException expection){
            System.out.println(expection);
        }
    }
    public ArrayList<Objects> readFromFile(){
        try{
            //Employee employee=new Employee();
            ArrayList<Objects> arry=new ArrayList<>();
            FileInputStream fileInputStream=new FileInputStream("EmployeeDetails.doc");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            arry= (ArrayList<Objects>) objectInputStream.readObject();
            // userList1.add((UserInformation) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(arry.size());
            return arry;
        }
        catch (IOException | ClassNotFoundException  ioException){
            System.out.println(ioException);
        }
        return null;
    }

}
