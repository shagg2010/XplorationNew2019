package com.saurabh.dada.iq.impl.multithreading;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Thread_ProducerConsumerUsingBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		int maxQueueSize = 10;
		
		Consumer c1 = new Consumer(queue, "c1");
		new Thread(c1).start();
		
		Producer p1 = new Producer(queue, maxQueueSize, "p1");
		Producer p2 = new Producer(queue, maxQueueSize, "p2");
		Producer p3 = new Producer(queue, maxQueueSize, "p3");

		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
		
		
		
	}
}

class Producer implements Runnable{
	private BlockingQueue<String> queue;
	private final int maxQueueSize;
	private String name;
	
	public Producer(final BlockingQueue<String> queue, final int maxQueueSize, String name) {
		this.name = name;
		this.queue = queue;
		this.maxQueueSize = maxQueueSize;
	}
	
	@Override
	public void run() {
		while(true) {
			while(queue.size()==maxQueueSize) {
				try {
					TimeUnit.MILLISECONDS.sleep(2500);
				}
				catch(InterruptedException e) { }		
			}
			if(queue.size()<maxQueueSize) {
				queue.add(produce());
			}
		}		
	}
	
	public String produce() {
		UUID uuid = UUID.randomUUID();
		String str = this.name + " | " + queue.size() + " | " +  uuid.toString();
		System.out.println("Producing: " + str);
		return str;
	}
}
class Consumer implements Runnable{

	private BlockingQueue<String> queue;
	private String name;
	
	public Consumer(final BlockingQueue<String> queue,String name) {
		this.name = name;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			if(queue.size()==0) {
				try {
					TimeUnit.MILLISECONDS.sleep(1500);
				}
				catch(InterruptedException e) { }
			}
			else {
				try {
					System.out.println("Consuming: "+ this.name + " | " + consume());
				}
				catch(Exception e) {}
			}
		}
	}
	
	public String consume() throws InterruptedException{
		return queue.take();
	}
}