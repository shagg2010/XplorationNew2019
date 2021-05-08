package com.saurabh.dada.iq.impl.a2018;

import java.util.concurrent.TimeUnit;

public class WaitAndNotify {
	public static void main(String[] args) throws InterruptedException{
		Object lock = new Object();
		DisplayNumber displayNumber = new DisplayNumber(100);
		Thread t1 = new Thread(new OddThread(lock, displayNumber));
		Thread t2 = new Thread(new EvenThread(lock, displayNumber));
		t2.start();
		t1.start();
	}
}

class DisplayNumber{
	private int number = 1;
	private int limit = number + 1;

	public DisplayNumber(int limit) {
		this.limit = limit;
	}
	public int getNumber() {
		return number;
	}

	public void incrementNumber() {
		this.number = number + 1;
	}

	public int getLimit() {
		return limit;
	}
	public void displayNumber(String prefix) {
		System.out.println(prefix + "" + this.number);
	}
}

class OddThread implements Runnable{
	
	private Object lock = null;
	private DisplayNumber displayNumber = null;
	
	public OddThread(Object lock, DisplayNumber displayNumber) {
		this.lock = lock;
		this.displayNumber = displayNumber;
	}
	
	@Override
	public void run() {
		try {
			while(displayNumber.getNumber() < displayNumber.getLimit()) {
				synchronized (lock) {
					if(displayNumber.getNumber()%2!=0) {
						displayNumber.displayNumber("O-");
						displayNumber.incrementNumber();
						TimeUnit.MILLISECONDS.sleep(500);
						lock.notify();
					}
					else {
						lock.wait();
					}
				}
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class EvenThread implements Runnable{

	private Object lock = null;
	private DisplayNumber displayNumber = null;
	
	public EvenThread(Object lock, DisplayNumber displayNumber) {
		this.lock = lock;
		this.displayNumber = displayNumber;
	}
	
	@Override
	public void run() {
		try {
			while(displayNumber.getNumber() < displayNumber.getLimit()) {
				synchronized (lock) {
					if(displayNumber.getNumber()%2==0 && (displayNumber.getNumber() < displayNumber.getLimit())) {
						displayNumber.displayNumber("E-");
						displayNumber.incrementNumber();
						lock.notify();
					}
					else {
						lock.wait();
					}
				}
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
