package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import sun.security.smartcardio.SunPCSC.Factory;

/**
 * @author yadas
 * Total time taken: 17441 ms.
Total time taken: 17394 ms.

Total time taken: 12246 ms.
Total time taken: 12246 ms.

Total time taken: 10437 ms.
Total time taken: 10296 ms.
 *
 */

public class FindAllDivisors {
	
	public static void main(String[] args) {
		try{
			long start = System.currentTimeMillis();
			int totalFactors=0;
			int maxFactors=-1;
			int number=-1;
			for(int num=4;num<100;num++){
				Set<Integer> factors = findFactors11(num);
				maxFactors=factors.size()>maxFactors?factors.size():maxFactors;
				totalFactors=totalFactors+factors.size();
				System.out.println(num+": " + factors);
				if(factors.size()==11){
					number=num;
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("Max factors: " + maxFactors + " for Number: " + number);
			System.out.println("Total factors: " + totalFactors);
			System.out.println("Total time taken: " + (end-start)+ " ms.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Set<Integer> listFactorsOptimizedv3(int t){
		SortedSet<Integer> factors = new TreeSet<Integer>();
		int lastDivisor=t;
		int firstDivisor=1;
		int incr=1;
		int i=2;
		if(t%2!=0){
			incr=2;
			i=3;
		}
		do{
			if(t%i==0){
				firstDivisor=i;
				lastDivisor=t/firstDivisor;
				factors.add(firstDivisor);
				factors.add(lastDivisor);
			}
			i=i+incr;
		}
		while(i<=lastDivisor);
		return factors;
	}
	
	public static Set<Integer> listFactorsOptimizedv2(int t){
		SortedSet<Integer> factors = new TreeSet<Integer>();
		int lastDivisor=t;
		int firstDivisor=1;
		int incr=1;
		int i=1;
		if(t%2!=0){
			incr=2;
			//i=3;
		}
		do{
			if(t%i==0){
				firstDivisor=i;
				lastDivisor=t/firstDivisor;
				factors.add(firstDivisor);
				factors.add(lastDivisor);
			}
			i=i+incr;
		}
		while(i<=lastDivisor);
		return factors;
	}
	
	private static Set<Integer> findFactors11(int num)
    {
        int incrementer = 1;
        if (num % 2 != 0){ //odd number
            incrementer = 2; //only test the odd ones
        }
        SortedSet<Integer> factors = new TreeSet<Integer>();
        for (int i = 1; i <= num/2; i=i+incrementer){
            if (num % i == 0){
            	factors.add(i);
            }
        }
        factors.remove(1);
        factors.add(num);
        return factors;
    }
	
	public static List<Integer> listFactorsOptimizedv1(int t){
		List<Integer> factors = new ArrayList<Integer>();
		int lastDivisor=t;
		int firstDivisor=1;
		if(t%2==1){
			int i=3;
			do{
				if(t%i==0){
					factors.add(i);
					if(firstDivisor==1){
						firstDivisor=i;
						lastDivisor=t/firstDivisor;
					}
				}
				i=i+2;
			}
			while(i<=lastDivisor);
		}
		else{
			int i=2;
			do{
				if(t%i==0){
					factors.add(i);
					if(firstDivisor==1){
						firstDivisor=i;
						lastDivisor=t/firstDivisor;
					}
				}
				i++;
			}
			while(i<=lastDivisor);
		}
		return factors;
	}
	
	public static List<Integer> listFactors(int t){
		List<Integer> factors = new ArrayList<Integer>();
		for(int i=2;i<=t/2;i++){
			if(t%i==0){				
				factors.add(i);
			}			
		}
		return factors;
	}

}
