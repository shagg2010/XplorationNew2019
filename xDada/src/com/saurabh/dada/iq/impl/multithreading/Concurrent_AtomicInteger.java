package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class Concurrent_AtomicInteger {

	public static void main(String[] args) throws InterruptedException {
		
		try {
			ProcessingThread pt = new ProcessingThread();
			Thread t1 = new Thread(pt, "t1");
			t1.start();
			Thread t2 = new Thread(pt, "t2");
			t2.start();
			t1.join();
			t2.join();
			System.out.println("Processing count Atomic=" + pt.getCount());
			System.out.println("Processing count Integer=" + pt.getCountI());
		}
		catch(Exception e) {
			
		}
       
    }

}

class ProcessingThread implements Runnable {
    private AtomicInteger count = new AtomicInteger(0);
    private int countI = 0;
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
        	int mod = i % 100;
        	if(mod==0) {
            	System.out.println(i + " || "+ count + " || " + countI);
            }
            processSomething(i);
            count.incrementAndGet();
            countI++;
        }
    }

    public int getCount() {
        return this.count.get();
    }
    
    public int getCountI() {
		return countI;
	}

	private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}