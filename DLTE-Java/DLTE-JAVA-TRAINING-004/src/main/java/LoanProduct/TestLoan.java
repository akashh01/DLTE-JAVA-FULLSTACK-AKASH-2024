package LoanProduct;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;

public class TestLoan implements MyBank{
    @Override
    //to add a new loan to existing array
    public void addNewLoan() {
       for (int index=0;index<loan.length;index++){
           if(loan[index]==null){
                loan[index]=getInputData();
                break;
            }
       }

    }
    //to check for all the open loans
    @Override
    public void checkAvailibility(){
        for (int index=0;index<loan.length;index++){
            if(loan[index]!=null){
                if((loan[index].getLoanStatus()).equals("Open")){
                    System.out.println("Loan of "+loan[index].getBorrowerName()+" is still open");
                }

            }
            else{
                break;
            }
        }
    }
    //to check for all the closed loans
    public void closedLoans() {
        for (int index=0;index<loan.length;index++){
            if(loan[index]!=null){
                if(loan[index].getLoanStatus().equals("Close")){
                    System.out.println("Loan of "+loan[index].getBorrowerName()+" is closed");
                }

            }
            else{
                break;
            }
        }
    }
 //taking input for the new loan
    public Loan getInputData(){
        System.out.println("Enter the folowwing data");
        Scanner scanner=new Scanner(System.in);
        long loanNumber;
        System.out.println("Enter the loan number");
        loanNumber=scanner.nextLong();
        long loanAmount;
        System.out.println("Enter the loan amount");
        loanAmount= scanner.nextInt();
        Date loanDate=new Date();
        String loanStatus;
        System.out.println("Loan status");
        loanStatus=scanner.next();
        String borrowerName;
        System.out.println("Enter the borrowers name");
        borrowerName=scanner.next();
        Long borrowerContact;
        System.out.println("Enter the borrowers contact");
        borrowerContact=scanner.nextLong();
        return new Loan(loanNumber,loanAmount,loanDate,loanStatus,borrowerName,borrowerContact);
    }
    //main with menu for operation
    public static void main(String[] args) {
        TestLoan customers=new TestLoan();
        customers.initalize();
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("----WELCOME TO MY BANK----");
            System.out.println("ENTER 1 FOR ADDING LOAN DETAILS");
            System.out.println("ENTER 2 FOR CHECKING AVAILABLE LOAN");
            System.out.println("ENTER 3 FOR CHECKING CLOSED LOAN");
            choice=scanner.nextInt();
            switch(choice){
                case 1:customers.addNewLoan();
                       break;
                case 2:customers.checkAvailibility();
                       break;
                case 3:customers.closedLoans();
                       break;
            }
        }

    }



}
