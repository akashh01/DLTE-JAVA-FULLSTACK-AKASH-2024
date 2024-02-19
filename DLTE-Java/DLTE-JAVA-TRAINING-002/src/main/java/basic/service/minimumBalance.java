package basic.service;

import java.util.Scanner;

public class minimumBalance {
    public static void main(String[] args) {
        double[] accountBalance = new double[20];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the account balance of 20 customer");
        for (int index = 0; index < 20; index++) {
            accountBalance[index] = scanner.nextDouble();
        }
        //calling method for deducting charges
        putCharges(accountBalance);
        //displaying the new balance after deduction
        for (int index = 0; index < 20; index++) {
            System.out.println(accountBalance[index]);
        }
        return;
    }


    public static void putCharges(double[] minBalance) {
        double charges;
        for (int index = 0; index < 20; index++) {
            //applying 3% charges on balance
            if (minBalance[index] >= 5000 & minBalance[index] <= 9999) {
                charges = 0.03 * minBalance[index];
                minBalance[index] = minBalance[index] - charges;
            }
            //applying 5% charges on balance
            else if (minBalance[index] >= 1000 & minBalance[index] <= 4999) {
                charges = 0.05 * minBalance[index];
                minBalance[index] = minBalance[index] - charges;
            }


        }
    }

}