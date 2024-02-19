package basic.service;

import java.util.Scanner;
import java.util.function.LongFunction;

public class SIPcalculator {
    public static void main(String[] args) {
//        SIP calculator
//        Inputs: monthlyInvestment, expectedReturnsInPer, Period in years
//        Output: principle  Amount, Estimated returns, Total
        Long monthlyInvestment,totalNumofInvestments,expectedReturnsInPer,monthlyIntrestRate;
        double totalReturn;
        int numOfMonths;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Monthly Investment");
        monthlyInvestment=sc.nextLong();
        System.out.println("Enter expected return in %");
        expectedReturnsInPer=sc.nextLong();
        System.out.println("Enter time period in years");
        totalNumofInvestments=sc.nextLong();
        monthlyIntrestRate=totalNumofInvestments/12/100;
        numOfMonths= (int) (12*totalNumofInvestments);
        totalReturn=monthlyInvestment*((Math.pow((expectedReturnsInPer+1),totalNumofInvestments)/expectedReturnsInPer)*(expectedReturnsInPer+1));
        System.out.println(totalReturn);


    }
}
