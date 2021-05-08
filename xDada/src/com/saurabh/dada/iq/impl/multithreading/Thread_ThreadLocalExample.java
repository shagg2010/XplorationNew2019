package com.saurabh.dada.iq.impl;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread_ThreadLocalExample {

	public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 100D) );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("threadLocal Int: " + threadLocal.get());
        }
    }
	
	public static class MyRunnableWithoutThreadLocal implements Runnable {

        private Integer local = null;

        @Override
        public void run() {
            local = new Integer( (int) (Math.random() * 100D) );
    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
    
            System.out.println("int: " + local);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        MyRunnableWithoutThreadLocal sharedRunnableInstance2 = new MyRunnableWithoutThreadLocal();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        Thread thread10 = new Thread(sharedRunnableInstance2);
        Thread thread20 = new Thread(sharedRunnableInstance2);
        
        thread1.start();
        thread2.start();
        
        thread10.start();
        thread20.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
        
        thread10.join(); //wait for thread 1 to terminate
        thread20.join(); //wait for thread 2 to terminate
       
    }
}





