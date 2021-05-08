package com.saurabh.dada.iq.impl;

import java.util.concurrent.TimeUnit;

public class Thread_WaitAndNotifySignal {

	public static void main(String[] args) {
		Object lock = new Object();
		Thread t1 = new Thread(new WorkerThread1(lock));
		Thread t2 = new Thread(new WorkerThread2(lock));
		
		t1.start();
		t2.start();
	}

}

class WorkerThread1 implements Runnable{

	private Object lock = null;
	
	public WorkerThread1(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			try {
				System.out.println("Going for wait...");
				TimeUnit.MILLISECONDS.sleep(1000);
				lock.wait();
				System.out.println("Wait is over...");
			} catch (InterruptedException e) {
			}
		}
	}
}

class WorkerThread2 implements Runnable{

	private Object lock = null;
	
	public WorkerThread2(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			try {
				System.out.println("Going for notify...");
				TimeUnit.MILLISECONDS.sleep(1000);
				lock.notify();
				System.out.println("Notifed..., only after synchronized block is over the other thread will start just after wait...");
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Synchronized block over...");
	}
}