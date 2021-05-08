package com.saurabh.dada.iq.impl;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Lock_Semaphore {
	
	private final static Semaphore binarySemaphore = new Semaphore(2, true);

	public static void main(String[] args) {

		try{
			new Thread(new MutualExclusionTask("t1",binarySemaphore)).start();
			new Thread(new MutualExclusionTask("t2",binarySemaphore)).start();
			new Thread(new MutualExclusionTask("t3",binarySemaphore)).start();
			new Thread(new MutualExclusionTask("t4",binarySemaphore)).start();
			new Thread(new MutualExclusionTask("t5",binarySemaphore)).start();
			new Thread(new MutualExclusionTask("t6",binarySemaphore)).start();
			new Thread(new MutualExclusionTask("t7",binarySemaphore)).start();
			new Thread(new MutualExclusionTask("t8",binarySemaphore)).start();
			new Thread(new MutualExclusionTask("t9",binarySemaphore)).start();
			new Thread(new MutualExclusionTask("t10",binarySemaphore)).start();
	        
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
}

class MutualExclusionTask implements Runnable{

	private Semaphore semaphore;
	private String name;
	
	public MutualExclusionTask(String name,Semaphore semaphore){
		this.semaphore = semaphore;
		this.name = name;
	}
	
	@Override
	public void run() {
		mutualExclusion();		
	}
	private void mutualExclusion() {
        try {
        	System.out.println(this.name + " trying to acquire lock. [Semaphores remaining permits: " + semaphore.availablePermits() + "]");
        	semaphore.acquire();
        	System.out.println(this.name + " inside mutual exclusive region");
        	TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        	semaphore.release();
            System.out.println(this.name + " outside of mutual exclusive region");
        }
    }
	
}
	