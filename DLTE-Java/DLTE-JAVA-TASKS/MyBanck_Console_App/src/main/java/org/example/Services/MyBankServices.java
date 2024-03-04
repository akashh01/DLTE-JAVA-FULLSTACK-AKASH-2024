package org.example.Services;

import org.example.Entities.UserInformation;
import org.example.Exception.UserNotFoundException;
import org.example.Middleware.UserInformationFileRepository;
import org.example.Remotes.UserInfoRepository;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MyBankServices
{
    UserInfoRepository userInfoRepository;
    UserInformation user1=new UserInformation("Akash","akash123","Kannur","akash@gmail",987455545L,4444L);
    UserInformation user2=new UserInformation("Ajay","ajay123","Mangalore","ajay@gmail",9888888888L,500L);
    UserInformation user3=new UserInformation("Akshay","akshay123","Dubai","akshay@gmail",9777777888L,1000L);

    //  UserInformation user2=new UserInformation("ajay","ad1234");

    public MyBankServices() {
    }

    public void Intialize(){
         userInfoRepository=new UserInformationFileRepository();
         userInfoRepository.addInformation(user1);
         userInfoRepository.addInformation(user2);
         userInfoRepository.addInformation(user3);
    }
    public void callDeposit(String username,Long amount){
        try{
            userInfoRepository.DepositAmountInto(username,amount);
        }
        catch (UserNotFoundException exception){
            throw new UserNotFoundException();
        }
    }
    public void callValidateUser(String username){
        try {
            userInfoRepository.validateUser(username);
        }
        catch (UserNotFoundException exception){
            System.out.println(exception);
        }
    }


  //  public void saveNewData(UserInformation userInformation)

    //public static void main(String[] args) throws IOException, ClassNotFoundException {
      // UserInformation user1=new UserInformation("Akash","ad1234","Kannur","akash@gmail","88888888",4444L);
       //UserInformation user2=new UserInformation("Alan","ad1234","Kannur","akash@gmail","88888888",500L);
      //  UserInformation user2=new UserInformation("ajay","ad1234");

      //  userInformationFileRepository.addInformation(user1);
        //userInformationFileRepository.addInformation(user2);
     // userInformationFileRepository.DepositAmountInto("Alan",1000L);

      //     ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
        // Logger logger= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    }

