package com.saurabh.dada.iq.impl;

public class Thread_StoppingWithoutStopMethod {

	private static final int size=10;
	
	public static void main(String[] args) throws Exception {
		
		StoppableThread[] sThreads = new StoppableThread[size];
		for(int i=0;i<size;i++){
			sThreads[i] = new StoppableThread();
			sThreads[i].setName(""+(i+1));
			sThreads[i].start();
		}
		
		Thread.sleep(1000);
		
		for (int i = 0; i < size; i++) {
			sThreads[i].stopThread();
		}

	}
	
	private static class StoppableThread extends Thread {

	    private volatile boolean threadDone = false;
	    private volatile int count = 0;
	    private volatile Thread current;
	    
	    public StoppableThread(){
	    	current=Thread.currentThread();
	    }

	    public void stopThread() {
	        current = null;
	        threadDone = true;
	        System.out.println("Stopping Thread-" + this.getName() + " now.");
	    }

	    public void run() {
	        while (!threadDone) {
	            try{
	            	System.out.println("Thread-" + this.getName() + " running... " + (++count));
	            	Thread.sleep(100);
	            }
	            catch(InterruptedException e){}
	        }
	        
	        try{
            	System.out.println("About to sleep for 10 ms before final shutdown for Thread-" + this.getName());
            	Thread.sleep(10);
            	System.out.println("Sleep for 10 ms completed for Thread-" + this.getName());
            }
            catch(InterruptedException e){}
	    }

	}

}
