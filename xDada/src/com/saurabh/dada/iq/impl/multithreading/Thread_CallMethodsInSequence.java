package com.saurabh.dada.iq.impl.multithreading;

import java.util.concurrent.Semaphore;

public class Thread_CallMethodsInSequence {

	public static void main(String[] args) {
		
		Foo1 foo = new Foo1();
		
		Thread t1 = new Thread(new ThreadFirst(foo));
		Thread t2 = new Thread(new ThreadSecond(foo));
		Thread t3 = new Thread(new ThreadThird(foo));
		
		t2.start();
		t3.start();
		t1.start();
	}

}
class Foo1{
	private Semaphore sem1, sem2;
	public int pauseTime = 1000;
	
	public Foo1(){
		sem1=new Semaphore(1);
		sem2=new Semaphore(1);
		try{
			sem1.acquire();
			sem2.acquire();
		}
		catch(InterruptedException e){}
	}
	public void first(){
		try{
			System.out.println("Started Executing 1...");
			Thread.sleep(pauseTime);
			System.out.println("Finished Executing 1...");
			sem1.release(); //now releasing sem1 for thread-2 to acquire
		}
		catch(InterruptedException e){}
	}
	
	public void second(){
		try{
			sem1.acquire(); //this makes the second thread wait until first() method releases the lock (when invoked by thread-1) because its a binary semaphore
			sem1.release(); //releasing sem1, since its usage is over because the control is reached this statement
			System.out.println("Started Executing 2...");
			Thread.sleep(pauseTime);
			System.out.println("Finished Executing 2...");
			sem2.release(); //now releasing sem2 for thread-3 to acquire
		}
		catch(InterruptedException e){}
	}
	
	public void third(){
		try{
			sem2.acquire(); //this makes the third thread wait until second() method releases the lock (when invoked by thread-2)
			sem2.release(); //releasing sem1, since its usage is over
			System.out.println("Started Executing 3");
			Thread.sleep(pauseTime);
			System.out.println("Finished Executing 3");
		}
		catch(InterruptedException e){}
	}
}
class ThreadFirst implements Runnable{
	private Foo1 foo;
	public ThreadFirst(Foo1 foo){
		this.foo=foo;
	}
	@Override
	public void run() {
		foo.first();
	}
}
class ThreadSecond implements Runnable{
	private Foo1 foo;
	public ThreadSecond(Foo1 foo){
		this.foo=foo;
	}
	@Override
	public void run() {
		foo.second();
	}
}
class ThreadThird implements Runnable{
	private Foo1 foo;
	public ThreadThird(Foo1 foo){
		this.foo=foo;
	}
	@Override
	public void run() {
		foo.third();
	}
}