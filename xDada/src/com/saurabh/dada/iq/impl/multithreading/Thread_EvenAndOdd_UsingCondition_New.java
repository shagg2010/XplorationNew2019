package com.saurabh.dada.iq.impl;

import java.util.concurrent.atomic.AtomicBoolean;

public class Thread_EvenAndOdd_UsingCondition_New {

	public static void main(String... args) {
		final Object mutex = new Object();
		AtomicBoolean latchOpen = new AtomicBoolean(false);
		Thread t1 = new Thread(new NumberTask("odd", latchOpen, 1, mutex));
		Thread t2 = new Thread(new NumberTask("even", latchOpen, 2, mutex));
		t1.start();
		t2.start();
	}

	private static class NumberTask implements Runnable {
		private String id;
		private int count;
		private Object mutex;
		private AtomicBoolean latchOpen;

		NumberTask(String id, AtomicBoolean latchOpen, int count, Object mutex) {
			this.id = id;
			this.count = count;
			this.mutex = mutex;
			this.latchOpen = latchOpen;
		}

		public void run() {
			synchronized (mutex) {
				while (true) {
					if (!latchOpen.get() && id.equals("odd") || latchOpen.get()) {
						System.out.println(id + ": " + count);
						count += 2;
					}
					mutex.notifyAll();
					latchOpen.set(true);
					if (count <= 100) {
						try {
							mutex.wait();
						} catch (Exception e) {
							// ignore it.
						}
					} else {
						break;
					}
				}
			}
		}
	}

}
