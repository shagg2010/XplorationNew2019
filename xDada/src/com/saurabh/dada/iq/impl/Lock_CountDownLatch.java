package com.saurabh.dada.iq.impl;

import java.util.concurrent.CountDownLatch;

public class Lock_CountDownLatch {

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(3);
		new Thread(new ActionThread(latch)).start();
		new Thread(new DecrementorThread(latch)).start();
		
	}

}
class ActionThread implements Runnable{
	private final CountDownLatch latch;
	
	public ActionThread(CountDownLatch latch) {
        this.latch = latch;
    }

	@Override
	public void run() {
		try{
			System.out.println("Waiting for Countdown latch to get over...!");
			latch.await();
			System.out.println("Work Done.");
		}
		catch(InterruptedException e){
			//
		}
		System.out.println("Countdown latch over... Proceeding now!");
	}
}

class DecrementorThread implements Runnable{
	
	private final CountDownLatch latch;

    public DecrementorThread(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {

        try {
        	System.out.println("latch count: "+this.latch.getCount());
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("latch count: "+this.latch.getCount());

            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("latch count: "+this.latch.getCount());
            
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("latch count: "+this.latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}