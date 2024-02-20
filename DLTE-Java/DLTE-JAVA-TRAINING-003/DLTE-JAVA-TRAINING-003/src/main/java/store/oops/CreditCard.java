package store.oops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
//    public CreditCard(Long creditCardNumber, String creditCardHolder, Date creditCardExpiry, Integer creditCardCvv, Integer creditCardLimit, Date dateOfBillGenearation, Date dateOfBillPayment, Integer creditCardPin) {
//        CreditCardNumber = creditCardNumber;
//        CreditCardHolder = creditCardHolder;
//        CreditCardExpiry = creditCardExpiry;
//        CreditCardCvv = creditCardCvv;
//        CreditCardLimit = creditCardLimit;
//        DateOfBillGenearation = dateOfBillGenearation;
//        DateOfBillPayment = dateOfBillPayment;
//        CreditCardPin = creditCardPin;
//    }

    private Long CreditCardNumber;
    private String CreditCardHolder;
    private Date CreditCardExpiry;
    private Integer CreditCardCvv;
    private Integer CreditCardLimit;
    private Date DateOfBillGenearation;
    private Date DateOfBillPayment;
    private Integer CreditCardPin;


}
