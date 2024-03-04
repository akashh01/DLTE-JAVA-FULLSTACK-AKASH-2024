package genirics.example;
//3
public class DebitCard {
        private Long debitCardNumber;
        private String holderName;
        private Integer cvv;
        private Integer pin;

    public Long getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(Long debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public DebitCard(Long debitCardNumber, String holderName, Integer cvv, Integer pin) {
        this.debitCardNumber = debitCardNumber;
        this.holderName = holderName;
        this.cvv = cvv;
        this.pin = pin;


    }
}
