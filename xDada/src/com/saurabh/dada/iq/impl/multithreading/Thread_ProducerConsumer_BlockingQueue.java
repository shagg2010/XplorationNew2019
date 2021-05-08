package com.saurabh.dada.iq.impl.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Thread_ProducerConsumer_BlockingQueue {

	public static void main(String[] args) {

		try {
			BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>(2);
			Producer p1 = new Producer(q, "p1");
			Producer p2 = new Producer(q, "p2");
			Consumer c1 = new Consumer(q, "c1");
			Consumer c2 = new Consumer(q, "c2");
			Consumer c3 = new Consumer(q, "c3");
			Consumer c4 = new Consumer(q, "c4");

			new Thread(p1).start();
			new Thread(c1).start();
			new Thread(c2).start();

			new Thread(p2).start();
			new Thread(c3).start();
			new Thread(c4).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static class Producer implements Runnable {
		private final BlockingQueue<Integer> queue;
		private int i = 0;
		private final String name;

		public Producer(BlockingQueue<Integer> q, String name) {
			this.queue = q;
			this.name = name;
		}

		public void run() {
			try {
				int i = 0;
				while (i++ < 10) {
					queue.put(produce());
					Thread.sleep(500);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		private Integer produce() {
			Integer out = new Integer(++i);
			System.out.println("Producer [" + this.name + "] produces: " + out);
			return out;
		}
	}

	public static class Consumer implements Runnable {
		private final BlockingQueue<Integer> queue;
		private final String name;

		Consumer(BlockingQueue<Integer> q, String name) {
			queue = q;
			this.name = name;
		}

		public void run() {
			try {
				while (true) {
					consume(queue.take());
					Thread.sleep(250);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		private void consume(Object x) {
			System.out.println("Consumer [" + this.name + "] consumes: " + x);
		}
	}

}
