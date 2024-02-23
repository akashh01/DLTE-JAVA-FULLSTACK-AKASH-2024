package CreditCardAnalysis;

import java.util.Date;

public class CreditCard {

    private Long CreditCardNumber;
    private String CreditCardHolder;
    private Date CreditCardExpiry;
    private Integer CreditCardCvv;
    private Integer CreditCardLimit;
    private Date DateOfBillGenearation;
    private Date DateOfBillPayment;
    private Integer CreditCardPin;

    public Long getCreditCardNumber() {
        return CreditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        CreditCardNumber = creditCardNumber;
    }

    public String getCreditCardHolder() {
        return CreditCardHolder;
    }

    public void setCreditCardHolder(String creditCardHolder) {
        CreditCardHolder = creditCardHolder;
    }

    public Date getCreditCardExpiry() {
        return CreditCardExpiry;
    }

    public void setCreditCardExpiry(Date creditCardExpiry) {
        CreditCardExpiry = creditCardExpiry;
    }

    public Integer getCreditCardCvv() {
        return CreditCardCvv;
    }

    public void setCreditCardCvv(Integer creditCardCvv) {
        CreditCardCvv = creditCardCvv;
    }

    public Integer getCreditCardLimit() {
        return CreditCardLimit;
    }

    public void setCreditCardLimit(Integer creditCardLimit) {
        CreditCardLimit = creditCardLimit;
    }

    public Date getDateOfBillGenearation() {
        return DateOfBillGenearation;
    }

    public void setDateOfBillGenearation(Date dateOfBillGenearation) {
        DateOfBillGenearation = dateOfBillGenearation;
    }

    public Date getDateOfBillPayment() {
        return DateOfBillPayment;
    }

    public void setDateOfBillPayment(Date dateOfBillPayment) {
        DateOfBillPayment = dateOfBillPayment;
    }

    public Integer getCreditCardPin() {
        return CreditCardPin;
    }

    public void setCreditCardPin(Integer creditCardPin) {
        CreditCardPin = creditCardPin;
    }

    public CreditCard(Long creditCardNumber, String creditCardHolder, Date creditCardExpiry, Integer creditCardCvv, Integer creditCardLimit, Date dateOfBillGenearation, Date dateOfBillPayment, Integer creditCardPin) {
        CreditCardNumber = creditCardNumber;
        CreditCardHolder = creditCardHolder;
        CreditCardExpiry = creditCardExpiry;
        CreditCardCvv = creditCardCvv;
        CreditCardLimit = creditCardLimit;
        DateOfBillGenearation = dateOfBillGenearation;
        DateOfBillPayment = dateOfBillPayment;
        CreditCardPin = creditCardPin;
    }
}
