package com.saurabh.dada.iq.impl.multithreading;

public class Thread_RaceConditionExample {
	//https://netjs.blogspot.in/2015/06/race-condition-in-java-multi-threading.html
	public static void main(String[] args) {
		Count c = new Count();
		IncementNTimes incementNTimes1 = new IncementNTimes(c,100);
		IncementNTimes incementNTimes2 = new IncementNTimes(c,100);
		IncementNTimes incementNTimes3 = new IncementNTimes(c,100);
		Thread t11 = new Thread(incementNTimes1, "t1");
		Thread t22 = new Thread(incementNTimes2, "t2");
		Thread t33 = new Thread(incementNTimes3, "t3");
		t11.start();
		t22.start();
		t33.start();
		System.out.println("Value of x: " + c.getX());
		
		
        CounterS counterS = new CounterS();
        Thread t1 = new Thread(counterS, "T-1");
        Thread t2 = new Thread(counterS, "T-2");
        Thread t3 = new Thread(counterS, "T-3");
        t1.start();
        t2.start();
        t3.start();
        int a = 1;
        int b = -5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }
}

class IncementNTimes implements Runnable{

	private int n = 0;
	private Count c;
	
	public IncementNTimes(Count c, Integer n) {
		this.n = n;
		this.c = c;
	}
	
	public void runX() {
		for (int i = 0; i < n; i++) {
			int num = c.getX();
			System.out.println(Thread.currentThread().getName() + ", num: " + num);
			try {
				Thread.currentThread().sleep(10);
			}
			catch(Exception e) {
				//do nothing
			}
			c.setX(++num);
			System.out.println(Thread.currentThread().getName() + ", num: " + c.getX());
		}
	}
	
	//solution
	public void run() {
		synchronized (c) {
			for (int i = 0; i < n; i++) {
				int num = c.getX();
				System.out.println(Thread.currentThread().getName() + ", num: " + num);
				try {
					Thread.currentThread().sleep(10);
				}
				catch(Exception e) {
					//do nothing
				}
				c.setX(++num);
				System.out.println(Thread.currentThread().getName() + ", num: " + c.getX());
			}
		}
	}
}

class Count{
	private Integer x = new Integer(0);

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}
	
}

class CounterS  implements Runnable{
    private int c = 0;

    public void increment() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c++;
    }

    public void decrement() {    
        c--;
    }

    public int getValue() {
        return c;
    }
    
    @Override
    public void run() {
        this.increment();
        System.out.println("Value after increment [in " + Thread.currentThread().getName() + "]: " + this.getValue());
        this.decrement();
        System.out.println("Value after decrement [in " + Thread.currentThread().getName() + "]: " + this.getValue());
        
    }
    
    //solution is below
    
     /*@Override
     public void run() {
        synchronized(this){
        	this.increment();
            System.out.println("Value after increment [in " + Thread.currentThread().getName() + "]: " + this.getValue());
            this.decrement();
            System.out.println("Value after decrement [in " + Thread.currentThread().getName() + "]: " + this.getValue());
        }
        
    }*/

}