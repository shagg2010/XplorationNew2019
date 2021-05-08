package com.saurabh.dada.iq.impl.junit;

import junit.framework.TestCase;

public class JUnit_Example1 extends TestCase{
	
	protected int value1, value2;
	
	protected void setUp(){
	      value1 = 3;
	      value2 = 3;
	   }
	
	// test method to add two values
	public void testAdd() {
		double result = value1 + value2;
		assertTrue(result == 6);
	}

	protected void tearDown() {
		 value1 = 0;
	     value2 = 0;
	}
}
