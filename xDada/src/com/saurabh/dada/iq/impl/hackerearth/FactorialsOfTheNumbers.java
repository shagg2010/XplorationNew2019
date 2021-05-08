package com.saurabh.dada.iq.impl.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
 /**
  * https://www.hackerearth.com/problem/algorithm/small-factorials/submissions/
  * @author yadas
  *
  */
public class FactorialsOfTheNumbers {

	public static void main(String[] args) {
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);	        
	        String[] nums = new String[N];
	        for (int i = 0; i < N; i++) {
	        	line = br.readLine();
		        nums[i] = line;		        
	        }
	        for (int i = 0; i < N; i++) {
	        	BigInteger bigI = new BigInteger(nums[i]);
	        	System.out.println(factorial(bigI));
	        }
		}
		catch(IOException e){
			e.printStackTrace();
		}
		

	}
	
	public static BigInteger factorial(BigInteger num){
		if(num.intValue()==0)
			return new BigInteger("1");
		if(num.intValue()==1)
			return new BigInteger("1");
		else{
			num = num.multiply(factorial(num.subtract(new BigInteger("1"))));
		}
		return num;
	}

}
