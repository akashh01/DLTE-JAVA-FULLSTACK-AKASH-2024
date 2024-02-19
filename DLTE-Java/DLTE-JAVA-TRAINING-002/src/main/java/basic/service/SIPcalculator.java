package basic.service;

import java.util.Scanner;
import java.util.function.LongFunction;

public class SIPcalculator {
    public static void main(String[] args) {
//        SIP calculator -systematic investment plan.
//        Inputs: monthlyInvestment, expectedReturnsInPer, Period in years
//        Output: principle  Amount, Estimated returns, Total
        Long monthlyInvestment;
        double totalReturn,expectedReturnsPerYear, monthlyIntrestRate,EstimatedReturn,totalMoneyInvested;
        int numOfMonths,NumofYears;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Monthly Investment");
        monthlyInvestment=sc.nextLong();
        System.out.println("Enter expected return in %");
        expectedReturnsPerYear=sc.nextDouble();
        System.out.println("Enter time period in years");
        NumofYears=sc.nextInt();
        //converting return % per year to per months
        monthlyIntrestRate=expectedReturnsPerYear/12/100;
        numOfMonths=12*NumofYears;
        //formula for calculating sip
        totalReturn=monthlyInvestment*((Math.pow((1+monthlyIntrestRate),(numOfMonths))-1)*(1+monthlyIntrestRate))/monthlyIntrestRate;
        //total money invested,estimatedreturn ,total return
        totalMoneyInvested=numOfMonths*monthlyInvestment;
        EstimatedReturn=totalReturn-totalMoneyInvested;
        System.out.println("Total amount invested ="+totalMoneyInvested+"\nEstimated Return ="+EstimatedReturn+"\nTotal Return ="+totalReturn);



    }
}
