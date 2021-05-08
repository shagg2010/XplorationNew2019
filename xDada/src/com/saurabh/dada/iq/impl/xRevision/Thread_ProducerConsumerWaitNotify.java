package com.saurabh.dada.iq.impl.xRevision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Thread_ProducerConsumerWaitNotify {

	public static void main(String[] args) {
		final Queue<Integer> queue = new LinkedList<>();
		int maxSize = 3;
		
		Producer p = new Producer("Producer",queue,maxSize);
		Consumer c1 = new Consumer("Consumer1",queue,maxSize);
		Consumer c2 = new Consumer("Consumer2",queue,maxSize);
		Consumer c3 = new Consumer("Consumer3",queue,maxSize);
		
		p.start();
		c1.start();
		c2.start();
		c3.start();
	}

}

class Producer extends Thread{
	
	private int maxSize;
	private Queue<Integer> queue;
	
	public Producer(String name, final Queue<Integer> queue, int maxSize){
		super(name);
		this.maxSize=maxSize;
		this.queue=queue;
	}
	
	@Override
	public void run(){
		for(int i=0;i<30;i++){
			synchronized (queue) {
				while(queue.size()==maxSize){
					try {
						 System.out.println("Queue is FULL, Producer waiting!");
						 queue.wait(); 	//Since the wait() method in Java also releases the lock prior to waiting 
										//and re-acquires the lock prior to returning from the wait() method
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
				}
				Random random = new Random(); 
				int r = random.nextInt(); 
				System.out.println("Producing value : " + r); 
				queue.add(r); 
				queue.notifyAll();
			}
		}
	}
}


class Consumer extends Thread{
	
	private int maxSize;
	private Queue<Integer> queue;
	
	public Consumer(String name, final Queue<Integer> queue, int maxSize){
		super(name);
		this.maxSize=maxSize;
		this.queue=queue;
	}
	
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			synchronized (queue) {
				while(queue.isEmpty()){
					try {
						System.out.println("Queue is empty, " + getName() +" waiting!");
						queue.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
				}
				System.out.println(getName() + " consuming value : " + queue.remove()); 
				queue.notifyAll();
			}
		
		}
	}
}