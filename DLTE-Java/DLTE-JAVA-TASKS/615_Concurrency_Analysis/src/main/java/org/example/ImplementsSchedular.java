package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ImplementsSchedular {
    public static void main(String[] args) {
        TransactionAnalysis transactionAnalysis=new TransactionAnalysis();
        ScheduledExecutorService service= Executors.newScheduledThreadPool(1);
        ScheduledFuture future=service.scheduleAtFixedRate(transactionAnalysis,2,5, TimeUnit.SECONDS);
        service.schedule(new Runnable() {
            @Override
            public void run() {
                future.cancel(true);
                service.shutdown();
            }
        },30,TimeUnit.SECONDS);

    }

}
