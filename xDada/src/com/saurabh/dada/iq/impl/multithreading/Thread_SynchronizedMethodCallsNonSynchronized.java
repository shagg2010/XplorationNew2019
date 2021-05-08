package com.saurabh.dada.iq.impl;

import java.util.concurrent.TimeUnit;

public class Thread_SynchronizedMethodCallsNonSynchronized {

	public static void main(String[] args) {
		
		SomeWorkClass someWorkClass = new SomeWorkClass();
		SomeTask st = new SomeTask(someWorkClass);
		Thread t1 = new Thread(st, "t1");
		Thread t2 = new Thread(st, "t2");
		Thread t3 = new Thread(st, "t3");
		Thread t4 = new Thread(st, "t4");
		Thread t5 = new Thread(st, "t5");
		
		t1.start();t2.start();t3.start();t4.start();t5.start();
	}
}

class SomeWorkClass{
	public synchronized void methodOne() throws InterruptedException {
		System.out.println("Before calling methodTwo\t" + "Thread-name: " + Thread.currentThread().getName());
		TimeUnit.MILLISECONDS.sleep(10);
		methodTwo();
		TimeUnit.MILLISECONDS.sleep(10);
		System.out.println("After calling methodTwo\t\t" + "Thread-name: " + Thread.currentThread().getName());
	}
	
	public void methodTwo() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(10);
		System.out.println("Inside methodTwo\t\t" + "Thread-name: " + Thread.currentThread().getName());
		TimeUnit.MILLISECONDS.sleep(10);
	}
}

class SomeTask implements Runnable{

	private SomeWorkClass someWorkClass;
	public SomeTask(SomeWorkClass someWorkClass) {
		this.someWorkClass = someWorkClass;
	}
	
	@Override
	public void run() {
		try {
			someWorkClass.methodOne();
			someWorkClass.methodTwo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
