package com.saurabh.dada.iq.impl;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Test {

    static {
    	char[] chars = new char[] {'\u0063'}; String str = new String(chars);System.out.println(str);; byte[] bytes = str.getBytes(); System.out.println(Arrays.toString(bytes));
    	
        System.out.println(Test.k);
        k = 2;
        System.out.println(Test.k);
        }
    static int k = 1;

    public static void main(String[] args) {
    	
    	System.out.println(1.0/0.0);
    	System.out.println(Double.MIN_VALUE);
    	System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        System.out.println(k);
    }
}

public class WorkerFileMain {

	public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public static List<Integer> generateRandomIntegerData(int n){
		List<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		int low = 1;
		int high = 100;
		for(int i=0;i<n;i++) {
			int result = r.nextInt(high-low) + low;
			list.add(result);
		}
		return list;
	}
	static class Widening1 {
		  public void f1(Object o1) {
		    System.out.println("Inside f1 with object as argument");
		  }
		  public void f1(String s) {
		    System.out.println("Inside f1 with String as argument");
		  }
		  /*public void f1(Integer s){
			    System.out.println("Inside f1 with Integer as argument");
			  }*/
		}
	
	static class Overloading {
		   public void f1(Integer i){
			     System.out.println("inside 1");
			   }
			   public void f1(int i){
			     System.out.println("inside 2");
			   }
	}
	
	public static void main(String[] args) throws CloneNotSupportedException{
		
		try {
			
			System.out.println(10100%4);
			System.out.println(10100&4);
			
			if((3*0.1)==0.3)
				System.out.println("true");
			else
				System.out.println("false: " + (3*0.1f));
			//System.out.println(Integer.MIN_VALUE);
			//System.out.println(Math.abs(Integer.MIN_VALUE-1));;
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String example = "Convert Java String";
			byte[] bytes = example.getBytes();

			md.update(bytes, 0, bytes.length);
			byte[] mdbytes = md.digest(); // digest all the updates, and reset the MessageDigest

			System.out.println("SHA Checksum Input : " + Arrays.toString(bytes));
			System.out.println("SHA Checksum Output: " + Arrays.toString(mdbytes));
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < mdbytes.length; i++) {
				hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
			}

			System.out.println("Hex format : " + hexString.toString());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		int i = 132;
	    List list = new ArrayList<String>();
	    list.add(new Object());
	    list.add("Hi");
	    list.add(i);
	    for(Object o: list) {
	    	System.out.println("obj: " + o + "\t" + o.getClass().getName());
	    }
	  
	    new Widening1().f1(null);
	    new Overloading().f1(8);
		
		StackUsingQueue stack = new StackUsingQueue();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		System.out.println(stack);
		stack.pop();
		stack.pop();
		System.out.println(stack);
		stack.push("4");
		stack.push("5");
		System.out.println(stack);
		stack.pop();
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		
		
		QueueUsingStack q = new QueueUsingStack();
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		System.out.println(q);
		q.dequeue();
		q.dequeue();
		System.out.println(q);
		q.enqueue("4");
		q.enqueue("5");
		System.out.println(q);
		q.dequeue();
		q.dequeue();
		System.out.println(q);
		q.dequeue();
		System.out.println(q);
		
		System.exit(0);
		System.out.println("assignment: " + assignment());
		
		
		
		String a1 = "ab";
		System.out.println(a1.hashCode());
		String a2 = a1.substring(1);
		System.out.println(a2.hashCode());
		
		new Tempo();
		new Tempo();
		
		Class<?> integerClass = new Integer(5).getClass();
		System.out.println("instance: " + integerClass.isInstance(new Integer(4)));
		
		String s = "prasad";
		String s2 = new String("prasad");
		System.out.println(s.equals(s2));
		System.out.println(s == s2);
		//permutation("", s);
		
		String a = "this     is my asdasd  aas";
		System.out.println(a.replaceAll("\\s+", " "));
		
		Employee one  = new Employee(10);
		Employee two = (Employee) one.clone();

		System.out.println("one==two: " + (one==two));
		System.out.println("one.equals(two): " + one.equals(two));
		System.out.print("one.hashCode(): " + one.hashCode());
		System.out.println("\ttwo.hashCode(): " + two.hashCode());
		
		
		
	}
	
	

	
	public static int assignment() {
	    int number = 1;
	    try {
	        number = 3;
	        if (true) {
	        	System.out.println("Before throw...");
	            throw new Exception("Test Exception");
	        }
	        System.out.println("After throw...");
	        number = 2;
	    } catch (Exception ex) {
	    	System.out.println("In exception before return...");
	    	return number;
	    } finally {
	    	System.out.println("In finally...");
	        number = 4;
	    }
	    return number;
	}
	
	public static void permutation(String perm, String word) {
		if(word.isEmpty()) {
			System.out.println(perm);
		}
		else {
			for(int i=0;i<word.length();i++) {
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i+1, word.length()));
			}
		}
	}

	static class Employee implements Cloneable{
		private int id;
		
		public Employee(int id) {
			super();
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}
	
	static class ABC<T> extends ArrayList<T>{
		public boolean add(T t) {
			return true;
		}
	}
	
	
}

class StackUsingQueue{
	private LinkedList<String> queue = new LinkedList<String>();
	
	public void push(String data) {
		queue.addLast(data);
	}
	public String pop() {
		String data = null;
		LinkedList<String> q = new LinkedList<String>();
		while(queue.size()>1)
			q.addLast(queue.removeFirst());
		data = queue.removeFirst();
		while(!q.isEmpty())
			queue.addLast(q.removeFirst());
		return data==null?null:data;
	}
	public String toString() {
		StringBuilder sb= new StringBuilder("Stack: ");
		for(String i: queue) {
			sb.append(i + " -> ");
		}
		return sb.toString();
	}
}

class QueueUsingStack{
	private Stack<String> stack = new Stack<>();
	public String enqueue(String data) {
		return stack.push(data);
	}
	public String dequeue() {
		String data = null;
		if(stack.size()>1) {
			String item = stack.pop();
			dequeue();
			stack.push(item);
		}
		else {
			data = stack.pop();
		}
		return data==null?null:data;
	}
	public String toString() {
		StringBuilder sb= new StringBuilder("Queue: ");
		for(String i: stack) {
			sb.append(i + " -> ");
		}
		return sb.toString();
	}
}

class Tempo{

	private int a=0;
	{
		a=10;
		System.out.println("init : " + a);
	}
	{
		System.out.println("init2 : " + a);
		method();
	}
	public Tempo(){
		System.out.println("tempo cons");
	}
	
	public void method() {
		System.out.println("method");
	}
}
/*class TestExceptionPropagation2{  
	  void m() throws IOException{  
	    throw new java.io.IOException("device error");//checked exception  
	  }  
	  void n() throws IOException{  
	    m();  
	  }  
	  void p(){  
	   try{  
	    n();  
	   }catch(Exception e){System.out.println("exception handled");}  
	  }  
	  public static void main(String args[]){  
	   TestExceptionPropagation2 obj=new TestExceptionPropagation2();  
	   obj.p();  
	   System.out.println("normal flow");  
	  }  
	}*/