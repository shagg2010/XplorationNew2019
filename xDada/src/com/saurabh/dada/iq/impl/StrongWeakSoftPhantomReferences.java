package com.saurabh.dada.iq.impl;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class StrongWeakSoftPhantomReferences {

	public static void main(String[] args) {
		//Strong reference - Strong Reference is most simple as we use it in our day to day programming life e.g. in the code, String s = “abc” , 
		//reference variable s has strong reference to String object “abc”. 
		//Any object which has Strong reference attached to it is not eligible for garbage collection. 
		String s = "abc";
		
		//Weak-reference - Now as soon as you make strong reference counter = null, counter object created on line 1 becomes eligible for garbage collection; 
		//because it doesn’t have any more Strong reference and Weak reference 
		//by reference variable weakCounter can not prevent Counter object from being garbage collected.
		Counter counter = new Counter(); // strong reference
		WeakReference<Counter> weakCounter = new WeakReference<Counter>(counter); //weak reference
		counter = null; // now Counter object is eligible for garbage collection
		
		//Soft-reference - Soft Reference, Counter object is not garbage collected until JVM absolutely needs memory.
		Counter prime = new Counter();  // prime holds a strong reference - line 2
		SoftReference<Counter> soft = new SoftReference<Counter>(prime) ; //soft reference variable has SoftReference to Counter Object created at line 2
		prime = null;  // now Counter object is eligible for garbage collection but only be collected when JVM absolutely needs memory
		
		//Phantom reference is third kind of reference type available in java.lang.ref package. 
		//Phantom reference is represented by java.lang.ref.PhantomReference class. 
		//Object which only has Phantom reference pointing them can be collected whenever Garbage Collector likes it.
		Counter digit = new Counter(); // digit reference variable has strong reference - line 3
		ReferenceQueue<Counter> refQueue = new ReferenceQueue<>(); 
		PhantomReference<Counter> phantom = new PhantomReference<Counter>(digit,refQueue); // phantom reference to object created at line 3
		digit = null;
		//As soon as you remove Strong reference, DigitalCounter object created at line 3 can be garbage collected at any time as it only has one more PhantomReference pointing towards it, 
		//which can not prevent it from GC’d.
		
		
		
	}
	
	public static class Counter{
		
	}

}
