package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface MyBank {
    ArrayList<Loan> loan=new ArrayList<>(20);
    //loan array
//    default void initalize(){
//      Loan  loanOne=new Loan(545454545L,5000L,new Date(2023,05,01),"Open","Akash",9874563214L);
//      Loan  loanTwo=new Loan(6074899222L,8000L,new Date(2022,06,02),"Close","Harith",9874564444L);
//      loan.addAll(Stream.of(loanOne,loanTwo).collect(Collectors.toList()));
//    }
    void writeIntoFile() throws IOException;
    void readFromFile() throws IOException, ClassNotFoundException;
    //to
    void addNewLoan(Loan loan);
    void checkAvailibility();
    void checkClosedLoan();

}
