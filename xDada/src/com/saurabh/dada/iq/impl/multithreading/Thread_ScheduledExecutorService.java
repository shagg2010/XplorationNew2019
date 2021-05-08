package com.saurabh.dada.iq.impl.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Thread_ScheduledExecutorService {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ScheduledExecutorService scheduledExecutorService =
		        Executors.newScheduledThreadPool(5);
		System.out.println("Code will be executed after a delay of 5 seconds...");
		ScheduledFuture<String> scheduledFuture = scheduledExecutorService.schedule(new Callable<String>() {
			public String call() throws Exception {
				System.out.println("Executed!");
				return "Called!";
			}
		}, 5, TimeUnit.SECONDS);

		if(scheduledFuture.isDone()) {
			System.out.println(scheduledFuture.get());
		}
		scheduledExecutorService.shutdown();
	}

}
