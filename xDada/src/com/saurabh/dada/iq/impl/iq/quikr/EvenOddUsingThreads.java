package com.saurabh.dada.iq.impl.iq.quikr;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddUsingThreads {

	public static void main(String[] args) throws Exception {
		ReentrantLock lock = new ReentrantLock();
		Condition e=lock.newCondition();
		Condition o=lock.newCondition();
		Thread t1 = new Thread(new ThreadOdd(lock,e,o,1,1000));
		Thread t2 = new Thread(new ThreadEven(lock,e,o,2,1000));
		t1.start();
		t2.start();
	}

}

class ThreadOdd implements Runnable{

	private final Lock lock;
	private final Condition runEven;
	private final Condition runOdd;
	private volatile int var;
	private final int limit;
	
	public ThreadOdd(Lock lock, Condition runEven, Condition runOdd, int start,int limit){
		this.lock=lock;
		this.runEven=runEven;
		this.runOdd=runOdd;
		this.var=start;
		this.limit=limit;
	}
	
	@Override
	public void run() {
		while(var<=limit){
			try{
				lock.lock();
				System.out.println("O-"+var);
				var=var+2;
				runEven.signalAll();
				runOdd.await(100, TimeUnit.MILLISECONDS);
				//System.out.println("afer calling await in Odd!"); this will execute after await like finally block
			}
			catch(InterruptedException e){ }
			finally{
				//System.out.println("lock release by odd!");
				lock.unlock();
			}
		}
	}
	
}


class ThreadEven implements Runnable{

	private final Lock lock;
	private final Condition runEven;
	private final Condition runOdd;
	private volatile int var;
	private final int limit;
	
	public ThreadEven(Lock lock, Condition runEven, Condition runOdd, int start, int limit){
		this.lock=lock;
		this.runEven=runEven;
		this.runOdd=runOdd;
		this.var=start;
		this.limit=limit;
	}
	
	@Override
	public void run() {
		while(var<=limit){
			try{
				lock.lock();
				//System.out.println("lock accquired by even!");
				System.out.println("E-"+var);
				var=var+2;
				runOdd.signalAll();
				runEven.await(100, TimeUnit.MILLISECONDS);
			}
			catch(InterruptedException e){ }
			finally{
				//System.out.println("lock release by even!");
				lock.unlock();
			}
		}
	}
	
}

