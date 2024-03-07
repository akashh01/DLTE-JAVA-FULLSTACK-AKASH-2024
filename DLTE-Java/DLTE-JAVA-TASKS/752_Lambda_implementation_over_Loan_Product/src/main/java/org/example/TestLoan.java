package org.example;

import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.MyBank.loan;

public class TestLoan {
    public static void main(String[] args) {
        TestLoan customers = new TestLoan();
        Loan loanOne = new Loan(545454545L, 5000L, new Date("1/1/2002"), "Open", "Akash", 9874563214L);
        Loan loanTwo = new Loan(6074899222L, 8000L, new Date("10/7/2003"), "Close", "Harith", 9874564444L);
        Loan loanThree = new Loan(123456987L, 9000L, new Date("15/8/2003"), "Close", "Ajay", 7874564444L);
        //loan.addAll(Stream.of(loanOne,loanTwo).collect(Collectors.toList()));
        //imported static constant loan from interface myBank
        loan.addAll(Stream.of(loanOne, loanTwo,loanThree).collect(Collectors.toList()));
        MyBank filter = ((startDate, endDate) -> {
            for (Loan each : loan) {
                if (each.getLoanDate().after(startDate) && each.getLoanDate().before(endDate)) {
                    System.out.println(each);
                }

            }
        });

        //calling
        System.out.println("Enter the start date to filter dd/mm/yyyy format");
        Scanner scanner=new Scanner(System.in);
        Date start=new Date(scanner.next());
        System.out.println("Enter the end date to filter dd/mm/yyyy format");
        Date end=new Date(scanner.next());
        filter.filterDate(start,end);



    }
}
