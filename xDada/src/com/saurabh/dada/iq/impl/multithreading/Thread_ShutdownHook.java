package com.saurabh.dada.iq.impl;

import java.util.concurrent.TimeUnit;

public class Thread_ShutdownHook {

	public static void main(String[] args) throws InterruptedException {

		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				System.out.println("Shutdown hook called!");
				//will be called when JVM is about to shut down
			}
		});
		
		TimeUnit.MILLISECONDS.sleep(1000);

	}

}
