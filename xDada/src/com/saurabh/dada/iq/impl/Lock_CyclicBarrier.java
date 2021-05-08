package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Lock_CyclicBarrier {

	public static void main(String[] args) {

		CyclicBarrier cb1 = new CyclicBarrier(5,new BarrierAction1());
		CyclicBarrier cb2 = new CyclicBarrier(5,new BarrierAction2());
		
		new Thread(new ThreadCB(cb1,cb2,"t1")).start();
		new Thread(new ThreadCB(cb1,cb2,"t2")).start();
		new Thread(new ThreadCB(cb1,cb2,"t3")).start();
		new Thread(new ThreadCB(cb1,cb2,"t4")).start();
		new Thread(new ThreadCB(cb1,cb2,"t5")).start();
		//cb1.reset();
	}

}
class ThreadCB implements Runnable{
	private final CyclicBarrier cb1;
	private final CyclicBarrier cb2;
	private String name;
	public ThreadCB(CyclicBarrier cb1,CyclicBarrier cb2,String name){
		this.cb1 = cb1;
		this.cb2 = cb2;
		this.name = name;
	}

	@Override
	public void run() {
		try{
			TimeUnit.MILLISECONDS.sleep(250); //do some work
			System.out.println(this.name+" completed required interim Barrier1 action");
			cb1.await();
			TimeUnit.MILLISECONDS.sleep(250); //do some work
			System.out.println(this.name+" completed required interim Barrier2 action");
			cb2.await();
		}
		catch(InterruptedException | BrokenBarrierException e){
			//
		}
	}
	
}

class BarrierAction1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Barrier1 Completed: " + Thread.currentThread().getName());
	}
	
}

class BarrierAction2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Barrier2 Completed: " + Thread.currentThread().getName());
	}
	
}

class CyclicBarrierDemo {

    private CyclicBarrier cyclicBarrier;
    private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
    private Random random = new Random();
    private int NUM_PARTIAL_RESULTS;
    private int NUM_WORKERS;

    private void runSimulation(int numWorkers, int numberOfPartialResults) {
        NUM_PARTIAL_RESULTS = numberOfPartialResults;
        NUM_WORKERS = numWorkers;

        cyclicBarrier = new CyclicBarrier(NUM_WORKERS, new AggregatorThread());
        System.out.println("Spawning " + NUM_WORKERS + " worker threads to compute " + NUM_PARTIAL_RESULTS + " partial results each");
        for (int i = 0; i < NUM_WORKERS; i++) {
            Thread worker = new Thread(new NumberCruncherThread());
            worker.setName("Thread " + i);
            worker.start();
        }
    }

    class NumberCruncherThread implements Runnable {

        @Override
        public void run() {
            String thisThreadName = Thread.currentThread().getName();
            List<Integer> partialResult = new ArrayList<>();
            for (int i = 0; i < NUM_PARTIAL_RESULTS; i++) {
                Integer num = random.nextInt(10);
                System.out.println(thisThreadName + ": Crunching some numbers! Final result - " + num);
                partialResult.add(num);
            }
            partialResults.add(partialResult);
            try {
                System.out.println(thisThreadName + " waiting for others to reach barrier.");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    class AggregatorThread implements Runnable {

        @Override
        public void run() {
            String thisThreadName = Thread.currentThread().getName();
            System.out.println(thisThreadName + ": Computing final sum of " + NUM_WORKERS + " workers, having " + NUM_PARTIAL_RESULTS + " results each.");
            int sum = 0;
            for (List<Integer> threadResult : partialResults) {
                System.out.print("Adding ");
                for (Integer partialResult : threadResult) {
                    System.out.print(partialResult + " ");
                    sum += partialResult;
                }
                System.out.println();
            }
            System.out.println(Thread.currentThread().getName() + ": Final result = " + sum);
        }

    }

    public static void main(String[] args) {
        CyclicBarrierDemo play = new CyclicBarrierDemo();
        play.runSimulation(5, 3);
    }

}