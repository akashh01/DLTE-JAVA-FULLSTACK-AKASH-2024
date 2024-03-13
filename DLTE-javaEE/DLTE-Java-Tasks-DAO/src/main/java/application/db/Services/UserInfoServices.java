package application.db.Services;

import application.db.Entities.Customer;
import application.db.Exception.UserNotFoundException;
import application.db.Remotes.StorageTarget;
import application.db.Remotes.UserInfoRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserInfoServices {
    UserInfoRepository userInfoRepository;
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("information");

    public UserInfoServices(StorageTarget storageTarget){
        userInfoRepository = storageTarget.getUserInfoRepository();
    }

    public boolean callValidateUser(String userName){
        try{

            boolean flag=userInfoRepository.validateUser(userName);
            return flag;
        }catch(UserNotFoundException userNotFoundException){
            throw userNotFoundException;
        }
    }

    public void callDepositAmountInto(String userName,Long amount){
        try{

            userInfoRepository.DepositAmountInto(userName,amount);
        }catch(UserNotFoundException userNotFoundException){
            throw userNotFoundException;
        }
    }

    public void callAddInformation(Customer customer){
        try{
            userInfoRepository.addInformation(customer);
        }catch(UserNotFoundException userNotFoundException){
            throw userNotFoundException;
        }
    }
    public boolean callPasswordValidate(String username, String password)
    {
        try {
         boolean check=userInfoRepository.passwordValidate(username,password);
         return check;
    }catch (Exception e){

        }
        return false;
    }

    public List callFindAll(){
        try{
            List<List> transaction=new ArrayList();
            transaction=userInfoRepository.findAll();
            return transaction;
        }catch (Exception e){

    }

    return null;

    }
    public List callOneUserTransact(String username){
        try{
            List<List> transaction=new ArrayList();
            transaction=userInfoRepository.findByUsername(username);
            return transaction;
        }catch (Exception e){

        }

        return null;

    }
    public List callTransactionByDate(String username,String date){
        try{
            List<List> transaction=new ArrayList();
            transaction=userInfoRepository.findByDateAndUsername(username,date);
            return transaction;
        }catch (Exception e){

        }

        return null;

    }

}
