package com.saurabh.dada.iq.impl.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread_EvenAndOdd_OwnIdeaWorkingInFirstTimeItself {

	public static void main(String[] args) {
		Object mutex = new Object();
		PrintNumber printNumber = new PrintNumber(mutex,250000);
		Thread tEven = new Thread(printNumber);
		Thread tOdd = new Thread(printNumber);
		tEven.start();
		tOdd.start();
	}
}
class PrintNumber implements Runnable{

	private AtomicInteger count = new AtomicInteger(0);
	private Object mutex = null;
	private AtomicBoolean isOdd = new AtomicBoolean(false);
	private int limit = 10;
	
	public PrintNumber(Object mutex, final int limit) {
		this.mutex = mutex;
		this.limit = limit;
	}
	
	@Override
	public void run() {
		try {
			synchronized (mutex) {
				while (count.get() <= limit) {
					if (isOdd.compareAndSet(false, true)) {
						System.out.println("Thread-Even: " + count.getAndIncrement());
						TimeUnit.MILLISECONDS.sleep(5);
					} else if (isOdd.compareAndSet(true, false)) {
						System.out.println("Thread-Odd: " + count.getAndIncrement());
						TimeUnit.MILLISECONDS.sleep(5);
					} else {
						mutex.wait();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception reported: " + e.getMessage());
		}
	}
}
