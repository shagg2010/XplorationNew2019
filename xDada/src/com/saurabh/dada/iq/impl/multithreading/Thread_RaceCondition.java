package com.saurabh.dada.iq.impl.multithreading;

public class Thread_RaceCondition {

	public static void main(String[] args) throws InterruptedException {

		NotThreadSafe sharedInstance = new NotThreadSafe();

		new Thread(new MyRunnable(sharedInstance),"1").start();
		new Thread(new MyRunnable(sharedInstance),"2").start();
		new Thread(new MyRunnable(sharedInstance),"3").start();
		new Thread(new MyRunnable(sharedInstance),"4").start();
		new Thread(new MyRunnable(sharedInstance),"5").start();
		new Thread(new MyRunnable(sharedInstance),"6").start();
		new Thread(new MyRunnable(sharedInstance),"7").start();
		new Thread(new MyRunnable(sharedInstance),"8").start();

		System.out.println(sharedInstance.returnText());
		
	}
}

class MyRunnable implements Runnable{
	NotThreadSafe instance = null;

	public MyRunnable(NotThreadSafe instance){
		this.instance = instance;
	}
	public void run(){
		this.instance.add("t" + Thread.currentThread().getName()+":some text");
	}
}

class NotThreadSafe{
	private StringBuilder builder = new StringBuilder();
	//private StringBuffer builder = new StringBuffer();
	int i = 0;

	public void add(String text){
		this.builder.append(text + ++i + "\t");
	}
	public String returnText() {
		return this.builder.toString();
	}
}

