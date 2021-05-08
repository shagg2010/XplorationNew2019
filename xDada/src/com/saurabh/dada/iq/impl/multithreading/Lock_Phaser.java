package com.saurabh.dada.iq.impl.multithreading;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class Lock_Phaser {
	
	   public static void main(String[] args){
		   
		   ExecutorService executorService = Executors.newCachedThreadPool();
		   Phaser ph = new Phaser(1);
		     
		   assertEquals(0, ph.getPhase());
		   
		   executorService.submit(new LongRunningAction("thread-1", ph));
		   executorService.submit(new LongRunningAction("thread-2", ph));
		   executorService.submit(new LongRunningAction("thread-3", ph));
		    
		   ph.arriveAndAwaitAdvance();
		     
		   assertEquals(1, ph.getPhase());
		   
		   executorService.submit(new LongRunningAction("thread-4", ph));
		   executorService.submit(new LongRunningAction("thread-5", ph));
		   ph.arriveAndAwaitAdvance();
		     
		   assertEquals(2, ph.getPhase());
		    
		   ph.arriveAndDeregister();
		   
	/*	List<Runnable> tasks = new ArrayList<>();
		tasks.add(new Runnable() {
			@Override
			public void run() {
				System.out.printf("%s running at %d%n", Thread.currentThread().getName(), System.currentTimeMillis());
			}
		});
		tasks.add(new Runnable() {
			@Override
			public void run() {
				System.out.printf("%s running at %d%n", Thread.currentThread().getName(), System.currentTimeMillis());
			}
		});
		runTasks(tasks);*/
	   }
	   /*
	    As you would expect from countdown latch behavior, both threads start running at (in this case) the same time even 
	    though a thread may have been delayed by as much as 349 milliseconds thanks to the presence of Thread.sleep().

		Comment out phaser.arriveAndAwaitAdvance(); // await all creation and you should now observe the threads starting
		 at radically different times
	    */
	   static void runTasks(List<Runnable> tasks){
	      final Phaser phaser = new Phaser(1); // "1" to register self
	      // create and start threads
	      for (final Runnable task: tasks){
	         phaser.register();
	         new Thread(){
	            @Override
	            public void run(){
	               try{
	                  Thread.sleep(50+(int)(Math.random()*800));
	               }
	               catch (InterruptedException ie){
	                  System.out.println("interrupted thread");
	               }
	               phaser.arriveAndAwaitAdvance(); // await all creation
	               task.run();
	            }
	         }.start();
	      }

	      // allow threads to start and deregister self
	      phaser.arriveAndDeregister();
	   }
}

class LongRunningAction implements Runnable {
    private String threadName;
    private Phaser ph;
 
    LongRunningAction(String threadName, Phaser ph) {
        this.threadName = threadName;
        this.ph = ph;
        ph.register();
    }
 
    @Override
    public void run() {
        ph.arriveAndAwaitAdvance();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ph.arriveAndDeregister();
    }
}
