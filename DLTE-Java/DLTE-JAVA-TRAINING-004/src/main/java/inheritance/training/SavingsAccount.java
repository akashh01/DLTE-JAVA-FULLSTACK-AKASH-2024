package inheritance.training;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class SavingsAccount {
    public SavingsAccount(){
        System.out.println("Initialize KYC to get account details");
    }
    private String accountHolder;
    private Long accountNumber;
    private Double accountBalance;

    public SavingsAccount(String accountHolder, Long accountNumber, Double accountBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
    public String toString(){
        return "SB account details "+getAccountHolder()+" and "+getAccountNumber()+" "+getAccountBalance()+"\n";
    }

    protected String getAccountHolder() {
        return accountHolder;
    }

    protected void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }


    protected Long getAccountNumber() {
        return accountNumber;
    }

    protected void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    void showSome(){
        System.out.println("Simple default method");
        System.out.println(getAccountBalance());
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

}


