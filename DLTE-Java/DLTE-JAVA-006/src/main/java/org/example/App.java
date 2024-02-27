package org.example;


public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        MyProvider provider=new MyProvider();

//        provider.update();
//        provider.report();
//        public void run(){
//
//
//        }
        Thread thread1=new Thread(provider,"Prashant");
        Thread thread2=new Thread(provider,"Shreyas");
        Thread thread3=new Thread(provider,"Srikanth");
        Thread thread4=new Thread(provider,"Annamalai");
       //thread4.setPriority(1);
        thread4.start();//thread4.join();
        thread1.start();//thread1.join();
        thread2.start();//thread2.join();
        thread3.start();//thread3.join();
        //thread4.start();

    }


}
