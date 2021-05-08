package com.saurabh.dada.iq.impl.multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_ProducerConsumer_CustomBlockingQueueWithLocksAndConditions {

	public static void main(String[] args) {
		BBlockingQueue<String> blockingQueue = new BBlockingQueue<String>();
		Thread producer1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<=10;i++) {
					blockingQueue.put("item1." + i);
				}
			}
		},"p1");
		
		Thread producer2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<=10;i++) {
					blockingQueue.put("item2." + i);
				}
			}
		},"p2");
		
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				for(;;) {
					try {
						System.out.println("\n\tfetching: " + blockingQueue.take());
						Thread.sleep(250l);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		},"c");
		
		consumer.start();
		producer1.start();
		producer2.start();

	}

}

class BBlockingQueue<T> {
	
	private List<T> items = new LinkedList<>();
	private final Lock lock = new ReentrantLock();
	private Condition isFullCondition = lock.newCondition();
	private Condition isEmptyCondition = lock.newCondition();
	private int maxSize = 10;
	
	public void put(T item) {
		try {
			lock.lock();
			while(items.size()==maxSize) {
				isFullCondition.await();
			}
			System.out.println("putting: " + item);
			items.add(item);
			isEmptyCondition.signalAll();
		}
		catch(Exception e) {
			//do nothing as of now
		}
		finally {
			lock.unlock();
		}
	}
	
	public T take() {
		T item = null;
		try {
			lock.lock();
			while(items.size()==0) {
				isEmptyCondition.await();
			}
			isFullCondition.signalAll();
			item = items.remove(0);
		}
		catch(Exception e) {
			//do nothing as of now
		}
		finally {
			lock.unlock();
		}
		return item;
	}
}