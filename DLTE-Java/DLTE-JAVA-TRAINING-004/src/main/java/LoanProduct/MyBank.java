package LoanProduct;

import inheritance.training.SavingsAccount;

import java.util.Date;

public interface MyBank  {
    Loan[] loan=new Loan[3];
    //loan array
    default void initalize(){
        loan[0]=new Loan(545454545L,5000L,new Date(2023,05,01),"Open","Akash",9874563214L);
        loan[1]=new Loan(6074899222L,8000L,new Date(2022,06,02),"Close","Harith",9874564444L);
    }
    //to
    void addNewLoan();
    void checkAvailibility();



}
//why cant i  add default void addNewLoan here with body?