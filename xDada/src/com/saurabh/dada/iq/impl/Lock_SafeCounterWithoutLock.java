package com.saurabh.dada.iq.impl;

import java.util.concurrent.atomic.AtomicInteger;

public class Lock_SafeCounterWithoutLock {
	private final AtomicInteger counter = new AtomicInteger(0);

	public int getValue() {
		return counter.get();
	}
	public void increment() {
		while(true) {
			int existingValue = counter.get();
			int newValue = existingValue++;
			if(counter.compareAndSet(existingValue, newValue)) {
				return;
			}
		}
	}
}
