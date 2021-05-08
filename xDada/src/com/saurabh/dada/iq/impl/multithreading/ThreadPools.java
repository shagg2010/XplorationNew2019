package com.saurabh.dada.iq.impl.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPools {

	public static void main(String[] args) {
		try{
			List<Future<String>> outputs = new ArrayList<>();
			ExecutorService service = Executors.newFixedThreadPool(10);
			ExecutorService service1 = Executors.newFixedThreadPool(10);
			for (int i = 0; i < 100; i++) {
				if(i%2==0) {
					outputs.add(service.submit(new Task(i)));
					}
				else {
					outputs.add(service1.submit(new Task(i)));
				}
			}
			service.shutdown();
			service1.shutdown();
			for(Future<String> fut: outputs) {
				while(!fut.isDone()) {
					//do nothing
				}
				if(fut.isDone()) {
					System.out.println("Result: " + fut.get());
				}
			}
			System.out.println("Done!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
class Task implements Callable<String>{
    private int taskId;
  
    public Task(int id){
        this.taskId = id;
    }
  
    @Override
    public String call() {
    	try{
    		Thread.sleep(500);
    		//throw new RuntimeException("runtime exception!");
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
        return "Task ID : " + this.taskId +" performed by " 
                           + Thread.currentThread().getName();
    }
  
}