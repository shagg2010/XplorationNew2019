package com.saurabh.dada.iq.impl.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class Thread_ProducerConsumer_WithQueueUsingWaitNotify {

	public static void main(String[] args) {
		
        final Queue<Integer> sharedQ = new LinkedList<Integer>();
        
        Thread producer1 = new Producerz(sharedQ,"Producer1");
        Thread producer2 = new Producerz(sharedQ, "Producer2");
        Thread consumer = new Consumerz(sharedQ);

        consumer.start();
        producer1.start();
        producer2.start();
	}

}

class Producerz extends Thread {
    private final Queue<Integer> sharedQ;

    public Producerz(Queue<Integer> sharedQ, String name) {
        super(name);
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {

		for (int i = 1; i < 6; i++) {
			synchronized (sharedQ) {
				// waiting condition - wait until Queue is not empty
				while (sharedQ.size() >= 1) {
					try {
						sharedQ.wait();
					} catch (InterruptedException e) {
					}
				}
				System.out.println(Thread.currentThread().getName() +" producing : " + i);
				sharedQ.add(i);
				sharedQ.notifyAll();
			}
		}
    }
}

class Consumerz extends Thread {
    private final Queue<Integer> sharedQ;

    public Consumerz(Queue<Integer> sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while(true) {

            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() == 0) {
                    try {
                    	System.out.println("Queue is EMPTY, waiting!");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                int number = sharedQ.poll();
                System.out.println("consuming : " + number );
                sharedQ.notifyAll();
              
                //termination condition
                if(number == 3){break; }
            }
        }
    }
}
