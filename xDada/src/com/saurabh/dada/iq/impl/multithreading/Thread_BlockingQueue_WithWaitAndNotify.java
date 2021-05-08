package com.saurabh.dada.iq.impl.multithreading;

import java.util.LinkedList;
import java.util.List;

public class Thread_BlockingQueue_WithWaitAndNotify {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueueCuztom<String> blockingQueue = new BlockingQueueCuztom<String>();
		Thread producer1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<=10;i++) {
					blockingQueue.put("item1." + i);
				}
			}
		},"producer1");
		
		Thread producer2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<=10;i++) {
					blockingQueue.put("item2." + i);
				}
			}
		},"producer2");
		
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
		},"consumer");
		
		consumer.start();
		producer1.start();
		producer2.start();
	
	}

}

class BlockingQueueCuztom<T> {
	 
    private List<T> queue = new LinkedList<T>();
 
    private int limit = 2;
 
    public synchronized void put(T item) {
        while (queue.size() == limit) {
            try {
            	System.out.println("t-" + Thread.currentThread().getName() + " waiting...");
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("  t-" + Thread.currentThread().getName() + " adding: " + item);
        queue.add(item);
        notifyAll();
    }
 
    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty()) {
            try {
            	System.out.println("t-" + Thread.currentThread().getName() + " waiting...");
                wait();
            } catch (InterruptedException e) {}
        }
        notifyAll();
        return queue.remove(0);
    }
     
}