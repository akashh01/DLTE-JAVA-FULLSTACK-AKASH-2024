package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import application.db.Entities.Customer;
import application.db.Services.UserInfoServices;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import web.GroupAccount;
import web.SoapAccount;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest
{
    @Mock
    private UserInfoServices userInfoServices;
    private SoapAccount soapAccount;
    @Before
    public void initial() throws Exception{
        soapAccount=new SoapAccount();
        soapAccount.userInfoServices=userInfoServices;
    }
    @Test
    public void testFindByUser(){
        String username="Akash";
        StringBuilder builder = new StringBuilder("Deposit,0");
        builder.append("," + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
        transactionOne.add(builder);
        Customer customer=new Customer("Akash", "aksh321", "kannur", "akash@gmail.com", 829267177L, 1000000L,transactionOne);
        GroupAccount result=soapAccount.findUser(username);
        assertEquals("Expected single customer", 1, result.getCustomerList().size());
        assertEquals("Expected customer", customer, result.getCustomerList().get(0));

    }

    @Test
    public void testFindAll(){
        List<Customer> customers=getCustomerList();
        when(userInfoServices.callFindAll()).thenReturn(customers);
        GroupAccount result=soapAccount.findAll();
        verify(userInfoServices).callFindAll();
        assertEquals("Ecpected",generateJson(customers),result);

    }

    @Test
    public void testUpdate(){
        String username="Akash";
        StringBuilder builder = new StringBuilder("Deposit,0");
        builder.append("," + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
        transactionOne.add(builder);
        Long newAmount=900L;
        Customer customer=new Customer("Akash", "aksh321", "kannur", "akash@gmail.com", 829267177L, 1000000L,transactionOne);
        //  soapAccount.transactionUpdate("Akash",newAmount);
        assertEquals(customer,   soapAccount.transactionUpdate("Akash",newAmount));

    }

    private List<Customer> getCustomerList() {
        List<Customer> customers = new ArrayList<>();
        StringBuilder builder = new StringBuilder("Deposit,0");
        builder.append("," + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
        transactionOne.add(builder);
        customers.add(new Customer("Akash", "aksh321", "kannur", "akash@gmail.com", 829267177L, 1000000L,transactionOne));
        customers.add(new Customer("Amal", "amal123", "Mangalore", "amal@gmail", 987455335L, 1000L,transactionOne));
        customers.add(new Customer("Aneesh", "aneesh321", "Mangalore", "aneesh@gmail", 987455335L, 1000L,transactionOne));
        return customers;
    }

    private String generateJson(List<Customer> customers) {
        StringBuilder json = new StringBuilder("[");
        for (Customer customer : customers) {
            json.append(customerToJson(customer)).append(",");
        }
        json.deleteCharAt(json.length() - 1);
        json.append("]");
        return json.toString();
    }

    private String customerToJson(Customer customer) {
        return String.format("{\"username\":\"%s\",\"password\":\"%s\",\"address\":\"%s\",\"email\":\"%s\",\"contact\":%d,\"initialBalace\":%d}",
                customer.getUsername(), customer.getPassword(), customer.getAddress(), customer.getEmail(), customer.getContact(), customer.getInitialBalace());
    }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
