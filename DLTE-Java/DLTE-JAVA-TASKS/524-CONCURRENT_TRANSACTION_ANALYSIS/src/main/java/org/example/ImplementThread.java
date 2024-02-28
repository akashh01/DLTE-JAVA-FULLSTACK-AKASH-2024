package org.example;

public class ImplementThread {
    public static void main(String[] args) throws InterruptedException {
        TransactionAnalysis transactionAnalysis=new TransactionAnalysis();
        Thread thread1=new Thread(transactionAnalysis,"Akash");
        thread1.start();thread1.join();
        Thread thread2=new Thread(transactionAnalysis,"Abhishek");
        thread2.start();
        Thread thread3=new Thread(transactionAnalysis,"Ajay");
        thread3.start();
        //three threads with method reference
        Thread thread4=new Thread(transactionAnalysis::displayTransactionToWhom,"Amal");
        thread4.start();
        Thread thread5=new Thread(transactionAnalysis::displayAllRemarks,"Nandu");
        thread5.start();
        Thread thread6=new Thread(transactionAnalysis::displayAllAmount,"Amir");
        thread6.start();
        Thread thread7 =new Thread(transactionAnalysis,"Emad");
        thread7.start();
        Thread thread8=new Thread(transactionAnalysis,"Nafi");
        thread8.start();
        Thread thread9=new Thread(transactionAnalysis,"Nadah");
        thread9.start();
        Thread thread10=new Thread(transactionAnalysis,"Naina");
        thread10.start();

    }
}
