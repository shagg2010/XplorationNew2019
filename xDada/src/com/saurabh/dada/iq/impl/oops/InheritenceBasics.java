package com.saurabh.dada.iq.impl.oops;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InheritenceBasics {
	
	public static void main(String[] args) throws Exception{
		A1 a = new B1();
		a.aMethod();
		//note that, IOException is parent class and FileNotFoundException is child class and it perfectly allowed in inheritance
		//it means you can't widen the exception in throws (the overriding method must not throw new or broader CHECKED exceptions)
		
		//Also, The overriding method must not have more restrictive access modifier however it can have more broader access specifier.
		//i.e. aMethod() in class B1 can't have following signatures-
		//		protected void aMethod() throws FileNotFoundException
		//		void aMethod() throws FileNotFoundException
		
		a.sleep();
		
		//Constructors can throw exceptions, however note that you can also widen the exception in child class
		B1 b = null;
		b.sleep();
	}

}

class A1{
	
	public A1() throws FileNotFoundException{
		System.out.println("A1");
	}
	public void aMethod() throws IOException{
		System.out.println("A1's methods");
	}
	static void sleep() {
        System.out.println("A Animal sleeps");
    }
}

class B1 extends A1{
	{System.out.println("instance initializer block is invoked everytime during object creation");}  
	public B1() throws IOException{
		super(); //this will not call the superclass constructor again because super() call is already added
		System.out.println("B1");
	}
	public void aMethod() throws FileNotFoundException, NullPointerException{
		System.out.println("B1's methods");
	}
	static void sleep() {
        System.out.println("B Animal sleeps");
    }
}