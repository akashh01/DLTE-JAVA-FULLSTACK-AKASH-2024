package tasks;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DebitCard extends AccountDetails {
    //two additional features card number and card pin for debit card
    private Long CardNumber;
    private Integer cardPin;
    // getters setters and constructors
    public DebitCard(Long accountNumber, Long accountBalance, String accountHolder,Long cardNumber,Integer cardPin) {
        super(accountNumber, accountBalance, accountHolder);
        this.cardPin=cardPin;
        this.CardNumber=cardNumber;
    }
    public Long getCardNumber() {
        return this.CardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.CardNumber = cardNumber;
    }

    public Integer getCardPin() {
        return this.cardPin;
    }

    public void setCardPin(Integer cardPin) {
        this.cardPin = cardPin;
    }

    //check amount to be received as parameter is less than balance to approve withdraw
    //approve withdraw only if pin entered at running time is same as cardPin
    //withdraw amount selected
    public void withdraw(){
        System.out.println("Withdraw amount");
        Scanner scanner=new Scanner(System.in);
        int EnterPin=0;
        System.out.println("Enter your current pin");
        EnterPin=scanner.nextInt();
        long withdrawAmount=0L;
        if(EnterPin==getCardPin()){
        System.out.println("Enter the amount to be withdrawn");
        withdrawAmount=scanner.nextLong();
        if(withdrawAmount<=getAccountBalance()){
            System.out.println("Your amount is withdrawn");
             this.setAccountBalance(this.getAccountBalance()-withdrawAmount);
        }
        else{
            System.out.println("Insufficient Balance");
        }
        }
        else {
            System.out.println("Wrong pin");
        }

}}
