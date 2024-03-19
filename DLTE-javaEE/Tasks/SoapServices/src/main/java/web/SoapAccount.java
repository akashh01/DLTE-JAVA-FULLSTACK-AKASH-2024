package web;


import application.db.Entities.Customer;
import application.db.Middlewares.DatabaseTarget;
import application.db.Remotes.StorageTarget;
import application.db.Services.UserInfoServices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService
    @SOAPBinding(style = SOAPBinding.Style.RPC)
    public class SoapAccount {
        private UserInfoServices userInfoServices;
        public SoapAccount() throws SQLException, IOException {
            StorageTarget storageTarget = new DatabaseTarget();
            userInfoServices =  new UserInfoServices(storageTarget);
        }

        @WebMethod
        @WebResult(name = "Create")
        public void createAccount(@WebParam(name = "String1") String userName, @WebParam(name = "String2") String password, @WebParam(name = "String3") String Address, @WebParam(name = "String4") String Email, @WebParam(name = "Long") Long contact, @WebParam(name = "Long1") Long initialBalance){
            StringBuilder builder = new StringBuilder("Deposit,0");
            builder.append("," + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            ArrayList<StringBuilder> transactionOne = new ArrayList<>();
            transactionOne.add(builder);
            Customer customer = new Customer(userName,password,Address,Email,contact,initialBalance,transactionOne);
            userInfoServices.callAddInformation(customer);
        }

        @WebMethod
        @WebResult(name = "findUsername")
        public GroupAccount findUser(@WebParam(name = "String") String username){
            GroupAccount groupAccount = new GroupAccount();
          //  Customer customer = userInfoServices.callByUsername(username);
            List<Customer> customerList = new ArrayList<>();
            //customerList.add(customer);
            groupAccount.setCustomerList(customerList);
            return groupAccount;
        }

        @WebMethod
        @WebResult(name = "TransactionUpdate")
        public void transactionUpdate(@WebParam(name = "String") String username,@WebParam(name = "Long") Long Amount){
            userInfoServices.callDepositAmountInto(username,Amount);
        }
    }
