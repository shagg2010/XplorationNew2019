package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class Lock_LockSupport_Park {

	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> iteratedNumbers = new ArrayList<>();
		  Thread thread1 = new Thread(() -> {
		    int i = 0;
		    // park() blocks thread invoking this method
		    LockSupport.park();
		    while (true) {
		      try {
		        Thread.sleep(1_000L);
		        iteratedNumbers.add(i);
		        i++;
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		        Thread.currentThread().interrupt();
		      }
		    }
		  });
		  thread1.start();
		 
		  Thread thread2 = new Thread(() -> {
		    try {
		      Thread.sleep(2_600L);
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		      Thread.currentThread().interrupt();
		    }
		    // unpark(Thread) releases thread specified
		    // in the parameter
		    LockSupport.unpark(thread1);
		  });
		  thread2.start();
		 
		  Thread.sleep(5_000L);
		  thread1.interrupt();
		
	}

}
