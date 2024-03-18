package org.example;

import web.AccountDetails;
import web.Customer;
import web.ReadAccount;
import web.ReadAccountService;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
       // ReadAccountService readAccountService=new ReadAccountService();
    //    AccountDetails accountDetails= (AccountDetails) readAccountService.getReadAccountPort();
        ReadAccountService service=new ReadAccountService();
        ReadAccount accountSoap=service.getReadAccountPort();

        //AccountDetails accountSoap = (AccountDetails) service.getReadAccountPort();
        List<Customer> cards = accountSoap.readAll("Eeksha").getDetails();
        for(Customer each:cards){
            System.out.println(each.getUsername()+" "+each.getPassword()+" "+each.getInitialBalace());
        }

    }
}
