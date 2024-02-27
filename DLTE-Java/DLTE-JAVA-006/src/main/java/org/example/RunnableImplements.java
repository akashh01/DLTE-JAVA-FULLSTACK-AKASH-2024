package org.example;
//test
class TestRunnable extends Thread{
    int counter=0;
    public void run(){
        counter++;
        System.out.println(counter+" for extends thread");
    }
}
class TestImplements implements Runnable{
    int counter=0;
    @Override
    public void run() {
        counter++;
        System.out.println(counter+ "for implements");
    }
}

 class RunnbleImplements{
    public static void main(String[] args)
    {
        TestRunnable thread1 = new TestRunnable();
        TestRunnable thread2 = new TestRunnable();
        thread1.start();
        thread2.start();
        System.out.println("-----------");
        TestImplements test=new TestImplements();
        Thread thread3=new Thread(test);
        Thread thread4=new Thread(test);
        thread3.start();
        thread4.start();
        
    }
}