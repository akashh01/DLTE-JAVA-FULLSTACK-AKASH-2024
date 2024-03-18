package web;


import application.db.Entities.Customer;
import application.db.Middlewares.DatabaseTarget;
import application.db.Remotes.StorageTarget;
import application.db.Services.UserInfoServices;
import org.omg.IOP.TransactionService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@WebService()
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class readAccount {
    UserInfoServices userInfoServices;
    public readAccount() throws SQLException {
        StorageTarget storageTarget = new DatabaseTarget();
        userInfoServices = new UserInfoServices(storageTarget);

    }


    @WebMethod
    @WebResult(name = "AccountDetails")
    public AccountDetails readAll(@WebParam(name="String") String username) {
        AccountDetails accountDetails = new AccountDetails();
        Scanner scanner = new Scanner(System.in);
     //   System.out.println("enter the username");
        Customer customer = userInfoServices.callOneUserDetails(username);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        accountDetails.setDetails(customerList);
        return accountDetails;
        //accountDetails=userInfoServices.callOneUserDetails(username);

    }

}