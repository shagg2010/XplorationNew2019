package com.saurabh.dada.iq.impl.java8;

public class DefaultMethodsAndStaticMethodsInInterface {

	public static void main(String[] args) {
		A a = new Clazz();
		B b = new Clazz();
		
		a.foo();
		b.foo();
		A.bar();
	}

}

interface A {
    default void foo(){
       System.out.println("Calling A.foo()");
    }
    static void bar(){
    	System.out.println("Calling A.bar()");
    }
}
interface B {
    default void foo(){
       System.out.println("Calling B.foo()");
    }
}

class Clazz implements A,B {
	
	public void foo(){
		A.super.foo();
		B.super.foo();
	}
}