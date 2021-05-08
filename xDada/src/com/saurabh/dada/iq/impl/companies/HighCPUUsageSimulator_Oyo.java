package com.saurabh.dada.iq.impl.companies;

public class HighCPUUsageSimulator_Oyo {
    
    private final static int NB_ITERATIONS = 500000000;
   
    // ~1 KB data footprint
    private final static String DATA_PREFIX = "datadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata";

    public static void main(String[] args) {

		System.out.println("HIGH CPU Simulator 1.0");
		System.out.println("Author: Pierre-Hugues Charbonneau");
		System.out.println("http://javaeesupportpatterns.blogspot.com/");

		try {

			System.out.println("Thread Id: " + Thread.currentThread().getId());
			for (int i = 0; i < NB_ITERATIONS; i++) {
				// Perform some String manipulations to slowdown and expose looping process...
				String data = DATA_PREFIX + i;
			}

		} catch (Throwable any) {
			System.out.println("Unexpected Exception! " + any.getMessage() + " [" + any + "]");
		}

		System.out.println("HighCPUSimulator done!");
    }

}
