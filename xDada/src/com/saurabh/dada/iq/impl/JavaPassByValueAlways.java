package com.saurabh.dada.iq.impl;

public class JavaPassByValueAlways {

	public static void main(String[] args) {
		String x = new String("ab");
		change(x);
		System.out.println(x);
		
		//Object Reference is also pass by value (that means object's reference is passed by value)
		//Java is always pass-by-value. The difficult thing to understand is that Java passes objects as references and those references are passed by value.
		Dog aDog = new Dog("Max");
	    change(aDog);
	    if( aDog.getName().equals("Max") ){ //true
	        System.out.println( "Java passes by value." );
	    }else if( aDog.getName().equals("Fifi") ){
	        System.out.println( "Java passes by reference." );
	    }
	}
	 
	public static void change(String x) {
		x = "cd";
	}
	
	public static void change(Dog d) {
		  d.getName().equals("Max"); // true
		  d = new Dog("Fifi");
		  d.getName().equals("Fifi"); // true
	}
}

class Dog{
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog(String name){
		this.name = name;
	}
	
}