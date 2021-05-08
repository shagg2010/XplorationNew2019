package com.saurabh.dada.iq.impl.multithreading;

public class Thread_DaemonExample {

	public static void main(String[] args) throws InterruptedException {
		Thread daemon = new Thread(()
				  -> System.out.println("Hello from daemon!"));
				daemon.setDaemon(true);
				daemon.start();
				daemon.join();

	}

}
