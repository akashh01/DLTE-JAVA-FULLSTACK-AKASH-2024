package Fileprocessing;

import java.io.Serializable;
import java.util.Date;

public class DebitCard implements Serializable {
        private Long debitCardNumber;
        private Integer debitCardCvv;
        private Integer debitCardPin;
        private Date debitCardExpiry;

    public Long getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(Long debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public Integer getDebitCardCvv() {
        return debitCardCvv;
    }

    public void setDebitCardCvv(Integer debitCardCvv) {
        this.debitCardCvv = debitCardCvv;
    }

    public Integer getDebitCardPin() {
        return debitCardPin;
    }

    public void setDebitCardPin(Integer debitCardPin) {
        this.debitCardPin = debitCardPin;
    }

    public Date getDebitCardExpiry() {
        return debitCardExpiry;
    }

    public void setDebitCardExpiry(Date debitCardExpiry) {
        this.debitCardExpiry = debitCardExpiry;
    }

    public DebitCard(Long debitCardNumber, Integer debitCardCvv, Integer debitCardPin, Date debitCardExpiry) {
        this.debitCardNumber = debitCardNumber;
        this.debitCardCvv = debitCardCvv;
        this.debitCardPin = debitCardPin;
        this.debitCardExpiry = debitCardExpiry;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "debitCardNumber=" + debitCardNumber +
                ", debitCardCvv=" + debitCardCvv +
                ", debitCardPin=" + debitCardPin +
                ", debitCardExpiry=" + debitCardExpiry +
                '}';
    }
}
