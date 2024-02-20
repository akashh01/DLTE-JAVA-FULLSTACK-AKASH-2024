package store.oops;

import javax.xml.crypto.Data;
import java.util.Date;

public class CustomerSupport {
    public static void main(String[] args) {

           CreditCard[] myBank={
                   new CreditCard(8985122212L,"Akash",new Date(2034,12,11),123,10000,new Date(2031,05,06),new Date(2032,06,20),4567),
                   new CreditCard(89851444412L,"Annapoorna",new Date(2029,10,21),153,30000,new Date(2032,05,21),new Date(2038,06,20),4580),
                   new CreditCard(89851333312L,"Razaak",new Date(2030,9,15),163,20000,new Date(2039,05,07),new Date(2031,06,20),4500),
           };
           CustomerSupport support=new CustomerSupport();
           support.findEarlyExpire(myBank);
           support.sortingCustomers(myBank);
           support.list(myBank);
    }
    public void findEarlyExpire(CreditCard[] customers){
        for(CreditCard each:customers){
            if(each.getCreditCardExpiry().before(new Date(2030,01,02))){
                System.out.println(each.getCreditCardNumber()+"your card expired");
            }
        }
    }

    public void sortingCustomers(CreditCard[] customers) {
        CreditCard backup = null;
        for (int select = 0; select < customers.length; select++) {
            for (int next = select + 1; next < customers.length; next++) {
                if (customers[select].getCreditCardHolder().compareTo(customers[next].getCreditCardHolder()) > 0) {
                    backup = customers[select];
                    customers[select] = customers[next];
                    customers[next] = backup;
                }
            }
        }
    }
    public void list(CreditCard[] customers){
        System.out.println("Available customers");
        for(CreditCard each:customers){
            System.out.println(each);
        }
    }



}
