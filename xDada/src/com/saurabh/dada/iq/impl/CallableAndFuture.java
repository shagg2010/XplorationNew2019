package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {

	public static void main(String[] args) throws Exception {
		
		//with Runnable
		Runnable simpleTask = new SimpleTask();
		ExecutorService executor = Executors.newFixedThreadPool(2); //only two thread will be active at any given moment
		executor.execute(simpleTask);
		executor.submit(simpleTask);
		executor.submit(simpleTask);
		executor.shutdown();
		
		//with Callable
		ExecutorService xecutor = Executors.newFixedThreadPool(10);
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		for(int i=0; i< 100; i++){
			Callable<Integer> callableTask = new CallableTask(i+1);
			Future<Integer> future = xecutor.submit(callableTask);
			if (future.isDone()) {
				System.out.println("Callable Task " + (i+1) +" already completed!");
			}
            list.add(future);
        }
		int i=01;
		for(Future<Integer> fut : list){
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(i++ +": "+fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
		xecutor.shutdown();
		StringBuffer sBuff = new StringBuffer("Still executing");
		System.out.print(sBuff);
		sBuff=new StringBuffer();
		while(!executor.isTerminated() || !xecutor.isTerminated()){
			sBuff.append(".");
			System.out.print(sBuff);
		}
		System.out.println();
		if(executor.isTerminated()){
			System.out.println("Finished running all threads in executor thread-pool");
		}
		if(xecutor.isTerminated()){
			System.out.println("Finished running all threads in xecutor thread-pool");
		}
		
	}
	
	public static class CallableTask implements Callable<Integer>{
		
		private volatile int num = 0;
		
        public CallableTask(int num){
   	        this.num = num;
        }

		@Override
		public Integer call() throws Exception {
			int result = 0;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=1;i<=num;i++){
				result+=i;
			}
			return result;
		}
		
	}
	
	public static class SimpleTask implements Runnable{
		 
		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("SimpleTask, Runnable: Executing Logic");
		}
	}

}
