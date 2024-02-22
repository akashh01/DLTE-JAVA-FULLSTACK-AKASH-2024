package exceptions;

import java.util.ResourceBundle;
import java.util.logging.Logger;

public class CLI {
    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        MyAccount myAccount=new MyAccount();
        myAccount.accountNumber=9632362333L;
        myAccount.accountBalance=988551.54;
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
         //there are several logeger available in the java

        try {
            int toBeDebited = Integer.parseInt(args[0]);
            System.out.println(resourceBundle.getString("format.number"));
           // System.out.println(logger.);
            if (myAccount.accountBalance >= toBeDebited) {
                myAccount.accountBalance -= toBeDebited;
                System.out.println("Debited");
            } else {
                System.out.println("Insufficient balance");
            }
        }
        catch (NumberFormatException e){
            System.out.println(e);
            System.out.println("AMOUNT SHOULD BE IN NUMBER ONLY");
            main(new String[] {"205555500"});
        }

    }
}
class MyAccount{
    long accountNumber;
    double accountBalance;
}

