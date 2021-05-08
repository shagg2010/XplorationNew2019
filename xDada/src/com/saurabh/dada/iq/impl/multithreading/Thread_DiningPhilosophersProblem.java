package com.saurabh.dada.iq.impl.multithreading;

import java.lang.reflect.Array;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_DiningPhilosophersProblem {

	public static void main(String[] args) {
		//Not working
		Lock lock = new ReentrantLock();
		Chopstick leftChopstick = new Chopstick(lock);
		Chopstick rightChopstick = new Chopstick(lock);
		
		Philosopher[] philosophers = (Philosopher[]) Array.newInstance(Philosopher.class, 10);
		int i=1;
		for(Philosopher p: philosophers){
			p = new Philosopher(leftChopstick, rightChopstick,new Integer(++i)+"");
			p.start();
		}
	}

}

class Philosopher extends Thread{
	private int bites=10;
	private Chopstick leftChopstick;
	private Chopstick rightChopstick;
	
	public Philosopher(Chopstick leftChopstick,Chopstick rightChopstick,String name){
		this.leftChopstick=leftChopstick;
		this.rightChopstick=rightChopstick;
		this.setName(name);
	}
	
	public void run(){
		for(int i=0;i<bites;i++){
			eat();
		}
	}
	
	public synchronized void eat(){
		if(pickUpBothChopsticks()){
			System.out.print(this.getName());
			chew();
			System.out.println();
			putDownBothChopsticks();
		}
	}
	
	public boolean pickUpBothChopsticks(){
		if(!leftChopstick.pickUp())
			return false;
		if(!rightChopstick.pickUp()){
			leftChopstick.putDown();
			return false;
		}
		return true;
	}
	
	public void putDownBothChopsticks(){
		leftChopstick.putDown();
		rightChopstick.putDown();
	}

	public void chew() {
		System.out.print(".");
	}
}

class Chopstick{
	private Lock lock;
	
	public Chopstick(Lock lock){
		this.lock=lock;
	}
	
	public boolean pickUp(){
		return lock.tryLock();
	}
	
	public void putDown(){
		lock.unlock();
	}
}
