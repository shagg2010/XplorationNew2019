package com.saurabh.dada.iq.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import sun.nio.cs.HistoricallyNamedCharset;

public class CreatePrivateHiddenClassInstance  {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		try {
			HiddenPrivateClass hpc = new HiddenPrivateClass(1);
			//using reflection a create a new instance using the private constructor
			//calling default private constructor
			Constructor<HiddenPrivateClass> constructor = (Constructor<HiddenPrivateClass>) hpc.getClass().getDeclaredConstructor();
			constructor.setAccessible(true);
			HiddenPrivateClass hpc2 = constructor.newInstance();
			hpc2.displayHello("t1");
			
			HiddenPrivateClass2 hpc22 = HiddenPrivateClass2.class.getDeclaredConstructor().newInstance();
			hpc22.displayHello("t2");
			
			//below code will fail
			HiddenPrivateClass hpc1 = HiddenPrivateClass.class.newInstance();
			hpc1.displayHello("t2");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	

}

class HiddenPrivateClass{
	
	private HiddenPrivateClass(){
		//private class
		System.out.println("Private constructor called!");
	}
	
	public HiddenPrivateClass(Integer ... abc){
		this();
		System.out.println("Public constructor called!");
	}
	
	public void displayHello(String name){
		System.out.println("Hello, " + name+"!");
	}
}
class HiddenPrivateClass2 {
	public void displayHello(String name){
		System.out.println("Hello, " + name+"!");
	}
}
