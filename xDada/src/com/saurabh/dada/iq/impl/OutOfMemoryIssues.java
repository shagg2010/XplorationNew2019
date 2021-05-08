package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class OutOfMemoryIssues {
	
	//https://www.geeksforgeeks.org/understanding-outofmemoryerror-exception-java/
	
	public static void main(String[] args) throws Exception{
		Wrapper.method();
	}
	
	
	
//	public static void main(String[] args) {
//		try {
//			while(true) {
//				Heap.method();
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}

class Wrapper {
	/*
	 * Error 2 – GC Overhead limit exceeded : This error indicates that the garbage collector is running all the time and Java program is making very 
	 * slow progress. After a garbage collection, if the Java process is spending more than approximately 98% of its time doing garbage collection and 
	 * if it is recovering less than 2% of the heap and has been doing so far the last 5 (compile time constant) consecutive garbage collections, 
	 * then a java.lang.OutOfMemoryError is thrown.
	 * This exception is typically thrown because the amount of live data barely fits into the Java heap having little free space for new allocations.
	 */
	public static void method() throws Exception {
		Map m = new HashMap();
		m = System.getProperties();
		Random r = new Random();
		while (true) {
			int i = r.nextInt();
			m.put(i, "randomValue"+i);
			System.out.println(m.get(i));
		}
	}
}

class Heap {
	/*
	 * Error 1 – Java heap space : This error arises due to the applications that make excessive use of finalizers. 
	 * If a class has a finalize method, then objects of that type do not have their space reclaimed at garbage collection time. 
	 * Instead, after garbage collection, the objects are queued for finalization, which occurs at a later time
	 * 
	 * finalizers are executed by a daemon thread that services the finalization queue
	 * If the finalizer thread cannot keep up, with the finalization queue, then the Java heap could fill up and this type of OutOfMemoryError exception would be thrown
	 * The problem can also be as simple as a configuration issue, where the specified heap size (or the default size, if it is not specified) is insufficient for the application.
	 * 
	 */
	static List<String> list = new ArrayList<String>();

	public static void method() throws Exception {
		Integer[] array = new Integer[10000 * 10000];
	}
}