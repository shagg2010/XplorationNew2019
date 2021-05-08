package com.saurabh.dada.iq.impl;

public class Thread_UncaughtRuntimeException {

	public static void main(String[] args) {
		Thread t = new Thread(new Runner());
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
			 public void uncaughtException(Thread thread, Throwable throwable) {
			 System.out.println(thread.getName() + " has thrown " + throwable);
			 }
			 });
		t.start();
	}

}
class Runner implements Runnable{

	@Override
	public void run() {
		throw new IndexOutOfBoundsException("throwing IOOBE");
	}
	
}
