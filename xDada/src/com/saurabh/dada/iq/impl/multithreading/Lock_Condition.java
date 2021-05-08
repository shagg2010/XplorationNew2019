package com.saurabh.dada.iq.impl.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_Condition {

	public static void main(String[] args) {

		CustomBlockingQueue<Integer> q = new CustomBlockingQueue<Integer>(2);
		Producer2 p1 = new Producer2(q,"p1");
		Producer2 p2 = new Producer2(q,"p2");
		Consumer2 c1 = new Consumer2(q,"c1");
		Consumer2 c2 = new Consumer2(q,"c2");
		Consumer2 c3 = new Consumer2(q,"c3");
		Consumer2 c4 = new Consumer2(q,"c4");

		new Thread(p1).start();
		new Thread(c1).start();
		new Thread(c2).start();

		new Thread(p2).start();
		new Thread(c3).start();
		new Thread(c4).start();

	}

}
class CustomBlockingQueue<T>{
	
	private Condition isFullCondition;
	private Condition isEmptyCondition;
	private Lock lock;
	private int limit;
	private int size=0;
	private Queue<T> queue;
	/** http://javaexplorer03.blogspot.in/2016/05/design-own-blocking-queue.html
	**/
	public CustomBlockingQueue() {
	    this(10);
	}

	
	public CustomBlockingQueue(int limit) {
	    this.limit = limit;
	    lock = new ReentrantLock();
	    isFullCondition = lock.newCondition();
	    isEmptyCondition = lock.newCondition();
	    this.queue = new LinkedList<T>();
	}

	public void put(T t) {
		lock.lock();
		try {
			while (isFull()) {
				try {
					isFullCondition.await();
				} catch (InterruptedException ex) {
				}
			}
			queue.add(t);
			size++;
			isEmptyCondition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public T get() {
		T t = null;
		lock.lock();
		try {
			while (isEmpty()) {
				try {
					isEmptyCondition.await();
				} catch (InterruptedException ex) {
				}
			}
			t = queue.poll();
			size--;
			isFullCondition.signalAll();
		} finally {
			lock.unlock();
		}
		return t;
	}
	
	private boolean isFull(){
		return size==limit?true:false;
	}
	
	private boolean isEmpty(){
		return size==0?true:false;
	}
}

class Producer2 implements Runnable {
	private final CustomBlockingQueue<Integer> queue;
	private int i = 0;
	private final String name;

	Producer2(CustomBlockingQueue<Integer> q, String name) {
		this.queue = q;
		this.name=name;
	}

	public void run() {
		try {
			int i=0;
			while (i++<10) {
				Thread.sleep(125);
				for(int q=0;q<5;q++) {
					Thread.sleep(125);
					queue.put(produce());
				}
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	private Integer produce() {
		Integer out = new Integer(++i);
		System.out.println("Producer [" + this.name+ "] produces: " + out);
		return out;
	}
}

class Consumer2 implements Runnable {
	private final CustomBlockingQueue<Integer> queue;
	private final String name;

	public Consumer2(CustomBlockingQueue<Integer> q, String name) {
		queue = q;
		this.name = name;
	}

	public void run() {
		try {
			while (true) {
				consume(queue.get());
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	private void consume(Object x) {
		System.out.println("Consumer [" + this.name + "] consumes: " + x);
	}
}

