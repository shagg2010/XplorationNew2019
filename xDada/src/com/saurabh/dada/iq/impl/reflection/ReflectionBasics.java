package com.saurabh.dada.iq.impl.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionBasics {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.saurabh.dada.iq.impl.reflection.A");//prints A class loaded
		
		//to get only public constructors declared with the matching arguments
		Constructor<A> privateCons1 = (Constructor<A>)clazz.getConstructor(int.class);
		//or get the second declared constructor i.e. public explicit constructor in our case
		Constructor<A> privateCons2 = (Constructor<A>)clazz.getDeclaredConstructors()[1];
		
		System.out.println("privateCons1: " + privateCons1);
		
		A a1 = privateCons1.newInstance(1);
	
		privateCons2.setAccessible(true);
		A a2 = privateCons2.newInstance();
		//using class object to create new instance
		//A a = (A) clazz.newInstance();
		
		System.out.println("\nAll declared methods for the class: java.sql.Connection");
		Class c = Class.forName("java.sql.Connection");
		Method m[] = c.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i].toString());
		}
	}
}

class A{
	static{
		System.out.println("A class loaded");
	}
	private A(){
		System.out.println("A's default constructor");
	}
	public A(int a){
		super();
		System.out.println("A's explicit constructor: a-"+a);
	}
	public A(double a){
		super();
		System.out.println("A's explicit constructor: a(d)-"+a);
	}
	private void privateMethod(int a, int b) throws IllegalArgumentException{
		System.out.println("A's privateMethod: a-" + a+", b-"+b);
	}
}
