package com.saurabh.dada.iq.impl.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_ReentrantLock {

	private final Lock lock = new ReentrantLock();
    private AtomicInteger count = new AtomicInteger(0);

     //Locking using Lock and ReentrantLock
     public int getCount() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " gets Count: " + count.incrementAndGet());
            return count.intValue();
        } finally {
            lock.unlock();
        }
     }

     //Implicit locking using synchronized keyword
     public synchronized int getCountTwo() {
            return count.incrementAndGet();
     }

    

	public static void main(String args[]) {
		final Lock_ReentrantLock counter = new Lock_ReentrantLock();
		Thread t1 = new Thread("T1") {
			@Override
			public void run() {
				while (counter.getCount() <= 10) {
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread("T2") {
			@Override
			public void run() {
				while (counter.getCount() <= 10) {
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
		};

		t1.start();
		t2.start();

	}
}
