package org.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import web.AccountDetails;
import web.Customer;
import web.ReadAccount;
import web.ReadAccountService;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws IOException {
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
