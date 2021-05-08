package com.saurabh.dada.iq.impl.java8;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionsAndFunctionalInterfaces {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);

		list.forEach(n -> {System.out.print(n+" ");});
		
		//using anonymous class - prior to Java 8
		WorkerExecutor executor = new WorkerExecutor();
		executor.execute(new WorkerInterface() {
			@Override
			public void doWork() {
				System.out.println("\nDoing work using anonymous class.");
				
			}
		});
		
		//using Lambda expressions
		executor.execute(()->{System.out.println("Doing work using lambda expression.");});
	}
}

@FunctionalInterface
interface WorkerInterface{
	abstract void doWork();
}

class WorkerExecutor{
	
	public void execute(WorkerInterface workerInterface){
		workerInterface.doWork();
	}
}