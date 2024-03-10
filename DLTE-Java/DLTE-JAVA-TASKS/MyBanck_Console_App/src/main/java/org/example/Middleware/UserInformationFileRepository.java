package org.example.Middleware;

import org.example.Entities.Customer;
import org.example.Exception.UserNotFoundException;
import org.example.Remotes.UserInfoRepository;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class UserInformationFileRepository implements UserInfoRepository {
    private ArrayList<Customer> userList=new ArrayList<>();
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
    private Logger logger= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public UserInformationFileRepository() {
        try{
            FileHandler fileHandler=new FileHandler("userInfo-logs.txt",true);
            SimpleFormatter simpleFormatter=new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        }
        catch (IOException ioException){}
    }


    private void writeIntoFile(){
        try {
           // readFromFile();
            FileOutputStream fileOutputStream = new FileOutputStream("user.doc");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userList);
            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch (IOException expection){

        }
    }
       private void readFromFile(){
           try{
               File file=new File("user.doc");
               FileInputStream fileInputStream=new FileInputStream(file);
               ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
               userList=(ArrayList<Customer>) objectInputStream.readObject();
              // userList1.add((UserInformation) objectInputStream.readObject());
               objectInputStream.close();
               fileInputStream.close();
           }
           catch (IOException | ClassNotFoundException  ioException){
               System.out.println(ioException);
           }
       }


    @Override
    public Customer validateUser(String username) {
        readFromFile();
        Customer checkUsername=userList.stream().filter(each->each.getUsername().equals(username)).findFirst().orElse(null);
        if(checkUsername==null){
            logger.log(Level.INFO,resourceBundle.getString("user.name"));
            throw new UserNotFoundException();
        }
        logger.log(Level.INFO,resourceBundle.getString("user.valid"));
        return checkUsername;
    }

    @Override
    public void DepositAmountInto(String username,Long amount) {
        readFromFile();
        Customer checkUsername=userList.stream().filter(each->each.getUsername().equals(username)).findFirst().orElse(null);
        if(checkUsername==null){
            logger.log(Level.INFO,resourceBundle.getString("user.name"));
            throw new UserNotFoundException();
        }
        int index=userList.indexOf(checkUsername);
        Long currentAmount=userList.get(index).getInitialBalace();
        Long newBalance=currentAmount+amount;
        StringBuilder builder=new StringBuilder("Deposit,"+amount.toString());
        builder.append(","+new Date());
        userList.get(index).getTransactionDetails().add(builder);
        userList.get(index).setInitialBalace(newBalance);
        writeIntoFile();
        logger.log(Level.INFO,resourceBundle.getString("user.deposited"));
        System.out.println(userList.get(index).getUsername() + "  Your money has been deposited");
       // readFromFile();
        //System.out.println(userList);

    }

    @Override
    public void addInformation(Customer customer) {
        readFromFile();
        Customer check=userList.stream().filter(each->each.getUsername().equals(customer.getUsername())).findFirst().orElse(null);
        if(check!=null){
            System.out.println("username exists");
            return;
        }
        userList.add(customer);
        writeIntoFile();
        //readFromFile();
        System.out.println(userList);
       // readFromFile();

    }
   public void check(){
        readFromFile();
        System.out.println(userList);
    }
}
