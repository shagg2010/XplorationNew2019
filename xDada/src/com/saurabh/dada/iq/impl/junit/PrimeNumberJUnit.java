package com.saurabh.dada.iq.impl.junit;

import com.saurabh.dada.iq.impl.hackerearth.PrimeNumberEfficientAlgorithm;

import junit.framework.TestCase;

public class PrimeNumberJUnit extends TestCase {

	private int value1;

	public PrimeNumberJUnit(String testName) {
	super(testName);
	}

	protected void setUp() throws Exception {
	super.setUp();
	value1 = 3;
	}

	protected void tearDown() throws Exception {
	super.tearDown();
	value1 = 0;
	}

	public void testAdd() {
	boolean result = PrimeNumberEfficientAlgorithm.isPrime(value1);
	assertTrue(result);
	}

}
