package tasks;

import java.util.Scanner;

//GPay: upiPin, username
//PayBills:
//pay bill with required parameters of billerName, billedAmount, billerType
//Pay bill only if UPI entered is valid at running time with upiPin of the customer
public class Gpay extends AccountDetails {
    //feature of username and upi pin for online transaction
    String username;
    Integer upiPin;
    //getters setters and constructors
    public Gpay(Long accountNumber, Long accountBalance, String accountHolder,String username,Integer upiPin) {
        super(accountNumber, accountBalance, accountHolder);
        this.username=username;
        this.upiPin=upiPin;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUpiPin() {
        return upiPin;
    }

    public void setUpiPin(Integer upiPin) {
        this.upiPin = upiPin;
    }
    //pay bill using gpay
    public void payBills(String billerName,Long billedAmount,String billerType){
        int EnterPin=0;
        System.out.println("Enter the upi pin number");
        Scanner scanner=new Scanner(System.in);
        EnterPin=scanner.nextInt();
        if(EnterPin==getUpiPin()){
            if(billedAmount<=getAccountBalance()){
                System.out.println("Bill payed\n"+"Biller name= "+billerName+"\nbilledAmounnt="+billedAmount+"\nBill Type="+billerType);
                setAccountBalance(getAccountBalance()-billedAmount);
            }
            else{
                System.out.println("Insuficent balance");
            }
        }
        else{
            System.out.println("Incorrect password");
        }
        System.out.println(getAccountBalance());
    }

}
