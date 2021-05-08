package com.saurabh.dada.iq.impl;

public class DaemonThreadInAction {
	
	public static void main(String[] args) throws Exception{  
		DaemonThread t1 = new DaemonThread();// creating thread
		DaemonThread t2 = new DaemonThread();
		DaemonThread t3 = new DaemonThread();

		//t1.start();
		t1.setDaemon(true);// now t1 is daemon thread and this is not allowed after t1.start() is called 

		t1.start();// starting threads
		t2.start();
		t3.start();
		Runtime.getRuntime().exec("notepad.exe");
	}
	

}

class DaemonThread  extends Thread{
	
	@Override
	public void run() {
		if (Thread.currentThread().isDaemon()) {// checking for daemon thread
			System.out.println("daemon thread work");
		} else {
			System.out.println("user thread work");
		}

	}
}