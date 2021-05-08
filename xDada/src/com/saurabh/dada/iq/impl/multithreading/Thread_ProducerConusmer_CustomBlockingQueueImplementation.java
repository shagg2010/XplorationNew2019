package com.saurabh.dada.iq.impl.multithreading;

import java.util.LinkedList;
import java.util.List;

public class Thread_ProducerConusmer_CustomBlockingQueueImplementation {

	public static void main(String[] args) {
		
		ABlockingQueue<String> blockingQueue = new ABlockingQueue<String>();
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

class ABlockingQueue<T>{
	
	//private final Lock lock = new ReentrantLock();
	//private final Object lock = new Object();
	private List<T> list = new LinkedList<T>();
	private final int maxSize = 10;
	
	public synchronized void put(T item) {
		while (list.size()==maxSize) {
			try {
				System.out.println(Thread.currentThread().getName() + " waiting...");
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + " adding: " + item);
		list.add(item);
		notifyAll();
	}
	
	public synchronized T take() {
		while (list.size()==0) {
			try {
				System.out.println(Thread.currentThread().getName() + " waiting...");
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + " fetching...: " + list.get(0));
		notifyAll();
		return list.remove(0);
	}
	
}