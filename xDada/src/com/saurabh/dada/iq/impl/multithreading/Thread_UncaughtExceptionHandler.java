package com.saurabh.dada.iq.impl;

public class Thread_UncaughtExceptionHandler {

	public static void main(String[] args) {
		
		Thread myThread = new Thread(new Thread1());
		//set UncaughtExceptionHandler
		myThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			public void uncaughtException(Thread myT, Throwable e) {
				System.out.println(myT.getName() + " throws exception: " + e);
				e.printStackTrace(System.out);
				System.out.printf("Thread status: %s\n", myT.getState());
				myT.start();
			}
		});
		myThread.start();
	}

	static class Thread1 implements Runnable{

		@Override
		public void run() {
			System.out.println("ABC");
			Integer.parseInt("OOOO.0");
			System.out.println("XYZ");	
		}
	}
}
