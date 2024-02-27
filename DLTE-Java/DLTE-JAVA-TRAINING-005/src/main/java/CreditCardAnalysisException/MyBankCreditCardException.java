package CreditCardAnalysisException;

import java.util.ResourceBundle;

public class MyBankCreditCardException extends RuntimeException{
    public MyBankCreditCardException() {
        //if the exception occurs message from application.properties is imported and displayed
        super(ResourceBundle.getBundle("application").getString("exception.creditcard"));
    }
}
