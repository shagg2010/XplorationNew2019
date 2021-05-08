package com.saurabh.dada.iq.impl;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread_Thread_ID_Generator {

	public static void main(String[] args) {
		try {
			MyRunnableWithThreadIdGenerator t1 = new MyRunnableWithThreadIdGenerator();
			for(int i=0;i<10;i++) {
				Thread t11 = new Thread(t1);
				Thread t22 = new Thread(t1);
				t11.start();
				t22.start();
				//t11.join();
				//t22.join();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static class MyRunnableWithThreadIdGenerator implements Runnable{
		
		private static class ThreadId {
		    // Atomic integer containing the next thread ID to be assigned
		    private static final AtomicInteger nextId = new AtomicInteger(1);

		    // Thread local variable containing each thread's ID
		    private static final ThreadLocal<Integer> threadId =
		        new ThreadLocal<Integer>() {
		            @Override 
		            protected Integer initialValue() {
		                return nextId.getAndIncrement();
		            }
		    };

		    // Returns the current thread's unique ID, assigning it if necessary
		    public static int get() {
		        return threadId.get();
		    }
		}
		
		@Override
        public void run() {
           System.out.println("id: " + ThreadId.get());
        }
		
	}

}
