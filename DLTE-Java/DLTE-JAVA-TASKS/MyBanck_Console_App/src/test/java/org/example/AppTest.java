package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.Entities.Customer;
import org.example.Middleware.UserInformationFileRepository;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Long testAmount=0L;
    Customer customer;
    Customer customer1;
    UserInformationFileRepository userInformationFileRepository=new UserInformationFileRepository();
    @BeforeClass
    public void initial(){
         StringBuilder builder = new StringBuilder("Deposit,0");
         builder.append("," + new Date());
         ArrayList<StringBuilder> transactionOne = new ArrayList<>();
         transactionOne.add(builder);
         customer=new Customer("Akshira", "akshira123", "Kannur", "akash@gmail", 987455545L, 4444L, transactionOne);
         customer1 = new Customer("Ajay", "ajay123", "Mangalore", "ajay@gmail", 9888888888L, 500L, transactionOne);
         userInformationFileRepository.addInformation(new Customer("Akshira", "akshira123", "Kannur", "akash@gmail", 987455545L, 4444L, transactionOne));

        Long testAmount=customer.getInitialBalace();
    }


    @Test
    public void depositAmount()
    {

        userInformationFileRepository.DepositAmountInto("Akshira",1000L);
        Long newAmount=customer.getInitialBalace();
        assertEquals(testAmount,newAmount);
    }
}
