package com.saurabh.dada.iq.impl.multithreading;

public class Thread_InterruptExample implements Runnable {
	 
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("["+Thread.currentThread().getName()+"] Interrupted by exception!");
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new Thread_InterruptExample(), "myThread");
        myThread.start();
 
        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 2s...");
        Thread.sleep(2*1000L);
 
        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        myThread.interrupt();
    }
}
