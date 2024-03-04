package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class TransactionAnalysis{
    public static void main(String[] args) {
        Transactions transactions=new Transactions(new Date(2012,02,12),7896,"Akshay","Family");
        ArrayList<Object> transactionList=new ArrayList<>();
        transactionList.add(transactions);
        transactionList.stream().filter(transactions.getRemarks()->transactions.getRemarks()==)
    }

}
