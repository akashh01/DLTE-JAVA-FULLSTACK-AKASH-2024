package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLoan implements MyBank {
    ArrayList<Loan> loans=loan;
    @Override
    public void writeIntoFile() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("LoanDB.doc");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(loans);
        fileOutputStream.close();
        objectOutputStream.close();
    }

    @Override
    public void readFromFile() throws IOException, ClassNotFoundException {

//        FileInputStream fileInputStream=new FileInputStream("LoanDB.doc");
//        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
//        loans= (ArrayList<Loan>) objectInputStream.readObject();
//        int size=loans.size();
//        for(int index=0;index<size;index++) {
//            if (bankDataBase.get(index) != null) {
//                System.out.println(bankDataBase.get(index).toString());
//            }
//        }
    }

    @Override
    public void addNewLoan(Loan loan) {
        try {
            readFromFile();
        }
        catch (IOException|ClassNotFoundException E){

            System.out.println(E);
        }
        loans.add(loan);

        try {
            writeIntoFile();
        }
        catch (IOException E){

            System.out.println(E);
        }

    }

    @Override
    public Loan checkAvailibility() {
        try {
            readFromFile();
        }
        catch (IOException|ClassNotFoundException E){

            System.out.println(E);
        }
        List<Loan> avail=loans.stream().filter(each->each.getLoanStatus().equals("Open")).collect(Collectors.toList());
        //System.out.println(avail.forEach(each->each.getLoanStatus());
        avail.forEach(Loan->{
            System.out.println(Loan.toString());
        });
        Loan test=avail.get(0);
        return test;
    }


    @Override
    public Loan checkClosedLoan() {
        try {
            readFromFile();
        }
        catch (IOException|ClassNotFoundException E){

            System.out.println(E);
        }
        List<Loan> notAvail=loans.stream().filter(each->each.getLoanStatus().equals("Close")).collect(Collectors.toList());
        notAvail.forEach(Loan->{
            System.out.println(Loan.toString());
        });
        Loan test=notAvail.get(0);
        return test;
    }
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

    public static void main(String[] args) {
        TestLoan customers=new TestLoan();
        Loan  loanOne=new Loan(545454545L,5000L,new Date(2023,05,01),"Open","Akash",9874563214L);
        Loan  loanTwo=new Loan(6074899222L,8000L,new Date(2022,06,02),"Close","Harith",9874564444L);
        Loan  loanThree=new Loan(123456987L,9000L,new Date(2022,04,22),"Close","Ajay",7874564444L);
        loan.addAll(Stream.of(loanOne,loanTwo).collect(Collectors.toList()));
        try {
            customers.writeIntoFile();
        }
        catch (IOException E){

            System.out.println(E);
        }
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("----WELCOME TO MY BANK----");
            System.out.println("ENTER 1 FOR ADDING LOAN DETAILS");
            System.out.println("ENTER 2 FOR CHECKING AVAILABLE LOAN");
            System.out.println("ENTER 3 FOR CHECKING CLOSED LOAN");
            choice=scanner.nextInt();
            switch(choice){
                case 1:customers.addNewLoan(customers.getInputData());
                    break;
                case 2:customers.checkAvailibility();
                    break;
                case 3:customers.checkClosedLoan();
                    break;
            }
        }
    }

}
