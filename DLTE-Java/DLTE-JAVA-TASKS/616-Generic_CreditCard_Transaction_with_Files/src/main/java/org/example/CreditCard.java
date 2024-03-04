package org.example;

import java.io.Serializable;
import java.util.Date;

public class CreditCard implements Serializable {
    //credit card details
    private Long CreditCardNumber;
    private String CreditCardHolder;
    private Date CreditCardExpiry;
    private Integer CreditCardCvv;
    private Integer CreditCardLimit;
    private Integer CreditCardPin;

    @Override
    public String toString() {
        return "CreditCard{" +
                "CreditCardNumber=" + CreditCardNumber +
                ", CreditCardHolder='" + CreditCardHolder + '\'' +
                ", CreditCardExpiry=" + CreditCardExpiry +
                ", CreditCardCvv=" + CreditCardCvv +
                ", CreditCardLimit=" + CreditCardLimit +
                ", CreditCardPin=" + CreditCardPin +
                '}';
    }

    public CreditCard() {
    }

    public CreditCard(Long creditCardNumber, String creditCardHolder, Date creditCardExpiry, Integer creditCardCvv, Integer creditCardLimit, Integer creditCardPin) {
        CreditCardNumber = creditCardNumber;
        CreditCardHolder = creditCardHolder;
        CreditCardExpiry = creditCardExpiry;
        CreditCardCvv = creditCardCvv;
        CreditCardLimit = creditCardLimit;
        CreditCardPin = creditCardPin;
    }

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

    public Integer getCreditCardPin() {
        return CreditCardPin;
    }

    public void setCreditCardPin(Integer creditCardPin) {
        CreditCardPin = creditCardPin;
    }
}
