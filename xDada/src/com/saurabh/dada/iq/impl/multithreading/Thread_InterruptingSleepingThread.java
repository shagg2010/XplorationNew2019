package com.saurabh.dada.iq.impl.multithreading;

public class Thread_InterruptingSleepingThread {

	public static void main(String[] args) throws InterruptedException {
		Thread myThread1 = new Thread(new InterruptExample(), "myThread1");
		Thread myThread2 = new Thread(new InterruptExample2(), "myThread2");
		myThread1.start();
		myThread2.start();

		System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 2.5s...");
		Thread.sleep(2500);

		System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread and myThread2");
		myThread1.interrupt();
		myThread2.interrupt();
	}

}

class InterruptExample implements Runnable {

	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
			}
			System.out.println("[" + Thread.currentThread().getName() + "] After while loop!");
		} catch (Exception e) {
			System.out.println("[" + Thread.currentThread().getName() + "] Interrupted by exception!");
		}
	}
}

class InterruptExample2 implements Runnable {

	public void run() {
		try {
			Thread.sleep(5000);	
		} catch (Exception e) {
			System.out.println("["+Thread.currentThread().getName()+"] Interrupted by exception!");
		}
	}
}