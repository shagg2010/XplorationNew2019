package com.saurabh.dada.iq.impl.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Thread_ScheduledExecutorServiceExample {
	
	public static void main(String[] args) {
		
		ScheduledExecutorService scheduledExecutorService =
		        Executors.newScheduledThreadPool(5);

		ScheduledFuture<String> scheduledFuture = scheduledExecutorService.schedule(new ScheduledWork(1), 5, TimeUnit.SECONDS);
		
		scheduledExecutorService.scheduleAtFixedRate(new ScheduledWork2(1), 0, 1L, TimeUnit.SECONDS);
		// please comment the below shutdown command otherwise repetitive threads will not be invoked/started because executor will be closed.
		
		//scheduledExecutorService.shutdown();
		
	}

}
class ScheduledWork implements Callable<String>{
	
	int workId = 0;
	public ScheduledWork(int workId) {
		this.workId = workId;
	}

	@Override
	public String call() throws Exception {
        System.out.println("Executed " + this.workId + "!");
        return "Called " + this.workId++ + "!";
    }
	
}

class ScheduledWork2 implements Runnable{
	
	int workId = 0;
	public ScheduledWork2(int workId) {
		this.workId = workId;
	}

	@Override
	public void run() {
		 System.out.println("Executed Task " + this.workId + " @ " + new java.util.Date() + "!");
        this.workId++;
    }
	
}
