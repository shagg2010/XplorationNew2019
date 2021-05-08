package com.saurabh.dada.iq.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureAndFutureTaskDifference {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newCachedThreadPool();

		FutureTask<String> future = new FutureTask<>(new CallableTask<String>());

		// Cancelling code before run
		/*
		 * boolean b = future.cancel(true);
		 * System.out.println("Cancelled="+b);
		 */

		future.run();
		Future<String> future1 = es.submit(new CallableTask<String>());

		// Cancelling code after run
		/*
		 * boolean b = future.cancel(true);
		 * System.out.println("Cancelled="+b);
		 */

		try {
			String result = future.get();
			System.out.println("Result=" + result);
			String result1 = future1.get();
			System.out.println("Result1=" + result1);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("EXCEPTION!!!");
			e.printStackTrace();
		}

	}

}

class CallableTask<String> implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("Executing call()... " + Thread.currentThread().getName());
		/*
		 * if(1==1)
		 * throw new java.lang.Exception("Thrown from call()");
		 */
		return (String) "success";
	}

}
