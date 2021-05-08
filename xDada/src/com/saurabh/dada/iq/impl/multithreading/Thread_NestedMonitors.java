package com.saurabh.dada.iq.impl.multithreading;

public class Thread_NestedMonitors {

	public static void main(String[] args) {
		ThreadAction obj = new ThreadAction();

		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Starting... ");
				obj.action1();
				System.out.println("Done... ");
			}
		};

		Thread a1 = new Thread(r);
		Thread a2 = new Thread(r);
		a1.start();
		//a2.start();
	}

}

class ThreadAction {

	public void action1() {
		synchronized (this) {
			System.out.println("Inside action1 sync!");
			synchronized (this) {
				System.out.println("Sync 2");
			}
			System.out.println("Calling action2...");
			action2();
		}
	}

	public void action2() {
		synchronized (this) {
			System.out.println("Inside action2 sync!");
		}
	}
}