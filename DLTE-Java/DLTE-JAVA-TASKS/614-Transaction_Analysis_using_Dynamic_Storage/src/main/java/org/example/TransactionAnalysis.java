package org.example;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionAnalysis {
    static ArrayList<Transactions> transactionsList = new ArrayList<>();

    public static void main(String[] args) {
        TransactionAnalysis customerAnalyis = new TransactionAnalysis();
        Transactions transactions1 = new Transactions(new Date("8/24/2021"), 500, "Ajay", "Friend");
        Transactions transactions2 = new Transactions(new Date("9/24/2021"), 5000, "Deepansh", "Family");
        Transactions transactions3 = new Transactions(new Date("5/22/2021"), 6500, "Akash", "Education");
        Transactions transactions4 = new Transactions(new Date("8/24/2021"), 7000, "Current", "Bills");
        Transactions transactions5 = new Transactions(new Date("8/24/2021"), 50000, "Ajay", "Friend");
        transactionsList = (ArrayList<Transactions>) Stream.of(transactions1, transactions2, transactions3, transactions4, transactions5).collect(Collectors.toList());
        int choice;
        Scanner scanner = new Scanner(System.in);
        //menu for transaction analysis
        while (true) {
            System.out.println("----------TRANSACTION ANALYSIS------------");
            System.out.println("Choose 1 for least amount transferred\n" + "Choose 2 for maximum amount transferred\n" + "Choose 3 for filtering based on particular remark\n" + "Choose 4 sort in descendin based on beneficiary \n");
            choice = scanner.nextInt();
            //CreditCardAnalysis analysis = new CreditCardAnalysis();
            switch (choice) {
                case 1:
                    leastAmountTransferred();
                    break;
                case 2:
                    maximumAmountTransferred();
                    break;
                case 3:
                    System.out.println("Enter the start range date in mm/dd/yyyy format");
                    Date startDate=new Date(scanner.next());
                    System.out.println("Enter the start range date in mm/dd/yyyy format");
                    Date endDate=new Date(scanner.next());
                    rangeOfDate(startDate,endDate);
                    break;
                case 4:
                    System.out.println("property->date,remark,amount\n order-ascending,descending");
                    System.out.println("To sort based on choice enter property:order");
                    String propertyOrder=scanner.next();
                    TransactionComparator compare=new TransactionComparator(propertyOrder);
                    Collections.sort(transactionsList,compare);
                    transactionsList.forEach(System.out::println);
                    break;

            }

        }

    }
    public static void leastAmountTransferred() {
        Transactions leastTransaction = transactionsList.stream().min(Comparator.comparingDouble(Transactions::getAmountInTransaction)).orElse(null);
        System.out.println("Least amount transferred = "+leastTransaction.getAmountInTransaction());
    }
    public static void maximumAmountTransferred() {
        Transactions leastTransaction = transactionsList.stream().max(Comparator.comparingDouble(Transactions::getAmountInTransaction)).orElse(null);
        System.out.println("Maximum amount transferred = "+leastTransaction.getAmountInTransaction());
    }
    public static void rangeOfDate(Date start,Date end) {
        Transactions leastTransaction = transactionsList.stream().max(Comparator.comparingDouble(Transactions::getAmountInTransaction)).orElse(null);
        System.out.println("Maximum amount transferred = "+leastTransaction.getAmountInTransaction());
        List<Transactions> rangeByDateList = transactionsList.stream().filter(each->each.getDateOfTransaction().after(start)&&each.getDateOfTransaction().before(end)).collect(Collectors.toList());
        rangeByDateList.forEach(Transactions->{
            System.out.println(Transactions.toString());
        } );

    }



}