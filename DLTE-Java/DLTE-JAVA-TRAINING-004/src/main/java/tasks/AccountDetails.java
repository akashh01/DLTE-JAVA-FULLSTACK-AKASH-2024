package tasks;

import javax.jws.Oneway;

public class AccountDetails {
    //basic properties of account details
    private Long AccountNumber;
    private Long AccountBalance;
    private String AccountHolder;
    //constructors getters and setters
    public AccountDetails(Long accountNumber,Long accountBalance,String accountHolder) {
        this.AccountNumber = accountNumber;
        this.AccountBalance = accountBalance;
        this.AccountHolder = accountHolder;
    }

    public Long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.AccountNumber = accountNumber;
    }

    public Long getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.AccountBalance = accountBalance;
    }

    public String getAccountHolder() {
        return AccountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.AccountHolder = accountHolder;
    }

    public String toString(){
        return getAccountHolder();
    }


}

