package com.saurabh.dada.iq.impl.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_BlockingQueueCustom {

	public static void main(String[] args) {
		
		MyBlockingQueue<Integer> q = new MyBlockingQueue<Integer>();
		Producer1 p1 = new Producer1(q, "p1");
		Producer1 p2 = new Producer1(q, "p2");
		Consumer1 c1 = new Consumer1(q, "c1");
		Consumer1 c2 = new Consumer1(q, "c2");
		Consumer1 c3 = new Consumer1(q, "c3");
		Consumer1 c4 = new Consumer1(q, "c4");

		new Thread(p1).start();
		new Thread(c1).start();
		new Thread(c2).start();

		new Thread(p2).start();
		new Thread(c3).start();
		new Thread(c4).start();

	}

}
class MyBlockingQueue<T>{
	
	private Condition isFullCondition;
	private Condition isEmptyCondition;
	private Lock lock;
	private int limit;
	private int size=0;
	private Queue<T> queue;

	public MyBlockingQueue() {
	    this(100);
	}

	
	public MyBlockingQueue(int limit) {
	    this.limit = limit;
	    lock = new ReentrantLock();
	    isFullCondition = lock.newCondition();
	    isEmptyCondition = lock.newCondition();
	    this.queue = new LinkedList<>();
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

class Producer1 implements Runnable {
	private final MyBlockingQueue<Integer> queue;
	private int i = 0;
	private final String name;

	Producer1(MyBlockingQueue<Integer> q, String name) {
		this.queue = q;
		this.name=name;
	}

	public void run() {
		try {
			int i=0;
			while (i++<10) {
				Thread.sleep(1000);
				queue.put(produce());
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	Integer produce() {
		Integer out = new Integer(++i);
		System.out.println("Producer [" + this.name+ "] produces: " + out);
		return out;
	}
}

class Consumer1 implements Runnable {
	private final MyBlockingQueue<Integer> queue;
	private final String name;

	public Consumer1(MyBlockingQueue<Integer> q, String name) {
		queue = q;
		this.name = name;
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(500);
				consume(queue.get());
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	void consume(Object x) {
		System.out.println("Consumer [" + this.name + "] consumes: " + x);
	}
}

