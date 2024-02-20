package store.oops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {


    private Long CreditCardNumber;
    private String CreditCardHolder;
    private Date CreditCardExpiry;
    private Integer CreditCardCvv;
    private Integer CreditCardLimit;
    private Date DateOfBillGenearation;
    private Date DateOfBillPayment;
    private Integer CreditCardPin;


}
