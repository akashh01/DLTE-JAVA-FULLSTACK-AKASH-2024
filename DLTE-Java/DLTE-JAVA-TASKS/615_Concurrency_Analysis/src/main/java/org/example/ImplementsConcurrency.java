package org.example;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ImplementsConcurrency {
    public static void main(String[] args) {
        TransactionAnalysis transactionAnalysis=new TransactionAnalysis();
        Executor executor=Executors.newCachedThreadPool();
        executor.execute(transactionAnalysis);
        ThreadPoolExecutor poolExecutor=(ThreadPoolExecutor) executor;
        poolExecutor.shutdown();
    }
}
