package com.saurabh.dada.iq.impl.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * https://www.hackerearth.com/problem/algorithm/in-love-with-primes/
 * @author yadas
 *
 */
public class EvenNumberSumOfPrimes {

	//Note: All Even numbers are sum of two prime numbers
	
	public static void main(String[] args) {
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
	    	int num = Integer.parseInt(line);
	    	int[] arr = new int[num];
	    	for(int i=0;i<num;i++){
	    		line = br.readLine();
	    		arr[i] = Integer.parseInt(line);	    		
	    		//Note: All Even numbers are sum of two prime numbers
	    	}
	    	
	    	for(int i=0;i<num;i++){
	    		if(arr[i]==1||arr[i]==2||arr[i]==3){
	    			System.out.println("Arjit");
	    		}
	    		else {
	    			System.out.println("Deepa");
	    		}
	    	}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
