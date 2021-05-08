package com.saurabh.dada.iq.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread_EvenAndOddByUsingTwoThreads_Advanced {

	 public static void main(String[] args){
		    final int max = 100;
		    final AtomicInteger i = new AtomicInteger(0);
		    ExecutorService dd = Executors.newFixedThreadPool(2);
		    
		    final Object lock = new Object();

		    dd.execute(new Runnable() {
		        @Override
		        public void run() {
		            while (i.get() <= max) {
		                if (i.get() % 2 == 0) {
		                    System.out.print("e-" + i.getAndAdd(1));

		                    synchronized(lock){
		                        lock.notify();
		                    }
		                }else{
		                    synchronized(lock){
		                        try {
		                            lock.wait();
		                        } catch (InterruptedException e) {
		                            // TODO Auto-generated catch block
		                            e.printStackTrace();
		                        }
		                    }
		                }
		            }
		        }
		    });
		    dd.execute(new Runnable() {
		        @Override
		        public void run() {
		            while (i.get() <= max) {
		                if (i.get() % 2 != 0) {
		                    System.out.println(" o-" + i.getAndAdd(1));

		                    synchronized(lock){
		                        lock.notify();
		                    }
		                }else{
		                    synchronized(lock){
		                        try {
		                            lock.wait();
		                        } catch (InterruptedException e) {
		                            // TODO Auto-generated catch block
		                            e.printStackTrace();
		                        }
		                    }
		                }
		            }
		        }
		    });
		    do {
		        try {
		            Thread.currentThread().sleep(1000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    } while (i.get() < max);
		    System.out.println("\nDone");
		    dd.shutdown();
		}

}

