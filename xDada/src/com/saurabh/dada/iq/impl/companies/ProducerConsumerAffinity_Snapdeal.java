package com.saurabh.dada.iq.impl.companies;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProducerConsumerAffinity_Snapdeal {

	private static final int TOTAL_ACTIVE_THREADS = 100;
	//https://www.geeksforgeeks.org/snapdeal-interview-experience-set-16-off-campus-software-development-engineer/
	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		for(int i=0;i<TOTAL_ACTIVE_THREADS;i++) {
			Thread consumer = new Thread(new Consumer((i+1)+"", queue), "c-"+(i+1));
			consumer.start();
			Thread producer = new Thread(new Producer((i+1)+"", 15, queue), "p-"+(i+1));
			producer.start();
		}

		System.out.println("Done!");
	}

	public static class Producer implements Runnable{
		private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		private String id;
		private int messageSize;
		private BlockingQueue<String> queue;
		
		public Producer(String id, int messageSize, BlockingQueue<String> queue) {
			this.id=id;
			this.messageSize = messageSize;
			this.queue = queue;
		}
		public String produce() {
			StringBuilder builder = new StringBuilder();
			builder.append("[Producer-" + this.id + "] - ");
			int count = messageSize;
			while (count-- != 0) {
				int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
				builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}
			try {
				Random r = new Random();
				int Low = 10;
				int High = 100;
				int result = r.nextInt(High-Low) + Low;
				TimeUnit.MILLISECONDS.sleep(10 * result);
			} catch (InterruptedException e) {
			}
			System.out.println(builder);
			return builder.toString();
		}
		@Override
		public void run() {
			try {
				queue.put(produce());
				
			} catch (InterruptedException e) {
			}
		}	
	}
	
	public static class Consumer implements Runnable{
		private String id;
		private BlockingQueue<String> queue;
		private final AtomicBoolean running = new AtomicBoolean(false);

		public Consumer(String id, BlockingQueue<String> queue) {
			this.id = id;
			this.queue = queue;
		}
		
		public void consume(String message) {
			StringBuilder builder = new StringBuilder();
			builder.append("[Consumer-" + this.id + "] - ");
			builder.append(message);
			System.out.println(builder);
		}

		@Override
		public void run() {			
			try {
				running.set(true);
				while(running.get()) {
					String msg = queue.peek();
					if(msg!= null && msg.contains("[Producer-" + this.id + "] - ")) {
						int msgLen = this.id.length() + 14;
						consume(queue.take().substring(msgLen, msg.length()));
						running.set(false);
					}
					else {
						//make this thread to wait on queue
						TimeUnit.MILLISECONDS.sleep(25);
					}
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		public void stopImmediate() {
			running.set(false);
		}
		public boolean getRunning() {
			return running.get();
		}
	}
}
