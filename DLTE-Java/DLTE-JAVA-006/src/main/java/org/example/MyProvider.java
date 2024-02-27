package org.example;

import java.util.Arrays;

public class MyProvider implements Runnable{


    double[][] deposits={
        {8555.2,5555.14,5444.5},
        {9555.2,45555.14,5444.5},
            {48566.5,932423.48},
    };

//    public void start(){
//        System.out.println("called start");
//        super.start();
//    }
    public void update(){
        for(int row=0;row<deposits.length;row++){
            for(int column=0;column<deposits[row].length;column++){
                if(deposits[row][column]>2000&&deposits[row][column]<=10000){
                    deposits[row][column]+=deposits[row][column]*0.07;
                }
            }
        }
    }
    public void report(){
        System.out.println(Thread.currentThread().getName()+" has called the report");
        for(double[] row:deposits){
            System.out.println(Arrays.toString(row));
        }
    }
    //    synchronized public void run(){
    public void run(){
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getId());
        update();
        report();
//        synchronized (this){
//            report();
   }



}
