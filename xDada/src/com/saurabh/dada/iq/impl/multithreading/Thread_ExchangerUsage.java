package com.saurabh.dada.iq.impl.multithreading;

import java.util.concurrent.Exchanger;

public class Thread_ExchangerUsage {

	private Exchanger<String> exchanger = new Exchanger<>();
	
	private void start() {
		new Thread(new Producer(), "Producer").start();
		new Thread(new Consumer(), "Consumer").start();
	}

	public static void main(String[] args) {
		new Thread_ExchangerUsage().start();
	}
	
	private class Producer implements Runnable {
		private String queue;

		@Override
		public void run() {
			try {
				System.out.println("Producer started");
				// create tasks & fill the queue
				// exchange the full queue for a empty queue with Consumer
				queue = exchanger.exchange("'data for processing'");
				System.out.println(Thread.currentThread().getName()
						+ " now has " + queue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private class Consumer implements Runnable {

		private String queue;

		@Override
		public void run() {
			try {
				System.out.println("Consumer started");
				Thread.sleep(3000);
				// do procesing & empty the queue
				// exchange the empty queue for a full queue with Producer
				queue = exchanger.exchange("'processed data'");
				System.out.println(Thread.currentThread().getName()
						+ " now has " + queue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
