package com.saurabh.dada.iq.impl.hackerearth;

public class PrimeNumberEfficientAlgorithm {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i=1;i<10000000;i++){
			//System.out.println(i + "=" + isPrime(i));
			if(isPrime(i)){
				System.out.println(i);
			}
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("total time taken: " + (end) + " ms");
	}
	
	public static boolean isPrime(int n) {
	    //check if n is a multiple of 2
		if(n==1) return false;
		if(n==2) return true;
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n/2;i+=2) {
	    	//System.out.println(n+" checking with: " + i);
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

}
