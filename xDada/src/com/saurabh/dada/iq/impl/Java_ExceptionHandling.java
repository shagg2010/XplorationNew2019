package com.saurabh.dada.iq.impl;

public class Java_ExceptionHandling {

	//https://www.baeldung.com/java-exceptions-interview-questions
	public static void main(String[] args) {
		Java_ExceptionHandling me = new Java_ExceptionHandling();
		me.methodWithoutThrows();
	}
	
	public <T extends Throwable> T sneakyThrow(Throwable ex) throws T {
	    throw (T) ex;
	}
	public void methodWithoutThrows() {
	    this.<RuntimeException>sneakyThrow(new Exception("Checked Exception"));
	}

}
