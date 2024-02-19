package basic.service;

import java.util.Scanner;

public class NumberOfDebits {
    public static void main(String[] args) {
        int CountOfDebits=0,transactions;
        Long currentBalance=0L,newBalance=0L;
        Scanner scanner=new Scanner(System.in);
        //initial account balance before any transaction
        System.out.println("Enter the current balance");
        currentBalance=scanner.nextLong();
        //iterating total ten numbers of transaction
        for(transactions=1;transactions<=10;transactions++){
            System.out.println("Enter the current balance after "+transactions+" transaction");
            newBalance=scanner.nextLong();
            //if new balance entered is less than current then its debit, increment the count
            if(newBalance<currentBalance){
                CountOfDebits++;
            }
            currentBalance=newBalance;
        }
        System.out.println("Total number of debit transaction are "+CountOfDebits);
        scanner.close();
    }
}
