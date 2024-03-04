package org.example;

import java.util.Arrays;
import java.util.Date;

public class ExecuteBankdb {
    public static void main(String[] args) {
        MyBankDatabase<CreditCard> storeCardData= new MyBankDatabase<>();
        storeCardData.bankDataBase=new CreditCard[20];
        CreditCard creditCardOne=new CreditCard(878884155L,"Akash",new Date(2023,12,20),987,80000,1124);
        CreditCard creditCardTwo=new CreditCard(878884177L,"Amal",new Date(2023,12,13),987,80000,1124);
        //creating or adding new data
        System.out.println(storeCardData.createNewData(creditCardOne));
        storeCardData.createNewData(creditCardTwo);
        //System.out.println(Arrays.toString(storeCardData.bankDataBase));
        //System.out.println(storeCardData.bankDataBase[0].get);
        //reading data
        //System.out.println(storeCardData.readData(0).toString());
       //deleting data
        storeCardData.deleteData(1);
        //creating generic for transaction
        MyBankDatabase<Transactions> transactionData=new MyBankDatabase<>();
        Transactions transactionsOne=new Transactions(new Date(2023,12,20),5000,"Harith","FRIEND");



    }

}
