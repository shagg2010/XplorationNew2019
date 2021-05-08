package com.saurabh.dada.iq.impl;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Lock_AtomicConstructs {

	public static void main(String[] args) {
		
		AtomicLong atomicLong = new AtomicLong();
		System.out.println(atomicLong.getAndAdd(10));
		System.out.println(atomicLong.addAndGet(-10));
		
		String initialReference = "initial value referenced";

		AtomicReference<String> atomicStringReference = new AtomicReference<String>(initialReference);

		String newReference = "new value referenced";
		boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
		System.out.println("exchanged: " + exchanged);

		exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
		System.out.println("exchanged: " + exchanged);
		
		int[] ints = new int[10];
		ints[5] = 123;
		AtomicIntegerArray array = new AtomicIntegerArray(ints);
		System.out.println(array);
		array.set(5, 999);
		System.out.println(array);
		boolean swapped = array.compareAndSet(5, 999, 123);
		System.out.println(swapped + " \t" + array);
		int oldValue = array.getAndAdd(5, 3);
		System.out.println(array);

	}

}
