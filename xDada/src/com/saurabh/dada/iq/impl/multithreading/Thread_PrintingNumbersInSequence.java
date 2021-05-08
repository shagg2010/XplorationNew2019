package com.saurabh.dada.iq.impl.multithreading;

public class Thread_PrintingNumbersInSequence {

	//https://netjs.blogspot.in/2016/10/how-to-run-threads-in-sequence-java-program.html
	final static int MAX_LIMIT = 20;
    final static int NUMBER_OF_THREADS = 3;
    public static void main(String[] args) {
        // Shared object
        SharedPrinter sp = new SharedPrinter(MAX_LIMIT, NUMBER_OF_THREADS);
        // Creating 3 threads
        Thread t1 = new Thread(new SeqRunnable(sp, 1), "Thread1");
        Thread t2 = new Thread(new SeqRunnable(sp, 2), "Thread2");
        Thread t3 = new Thread(new SeqRunnable(sp, 0), "Thread3");

        t1.start();
        t2.start();
        t3.start();
    }
    
}
class SharedPrinter{
    int number = 1;
    int numOfThreads;
    int maxLimit;
    SharedPrinter(int maxLimit, int numOfThreads){
        this.maxLimit = maxLimit;
        this.numOfThreads = numOfThreads;
    }
    public void printNum(int result){
        synchronized(this) {
            while (number < maxLimit - 1) {
                while(number % numOfThreads != result){
                    try {
                        this.wait(); // causes the currrent thread to wait on SharedPrinter object
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + number++);
                this.notifyAll();
            }
        }
    }
}
class SeqRunnable implements Runnable{
    SharedPrinter sp;
    int result;
    public SeqRunnable(SharedPrinter sp, int result){
        this.sp = sp;
        this.result = result;
    }
    @Override
    public void run() {
        sp.printNum(result);
    }
}