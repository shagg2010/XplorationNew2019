package com.saurabh.dada.iq.impl;

public class DivisionOfANumberWithoutDivisionOperator {

	private static int x = 1000;
	private static int y = 6;
	
	public static void main(String[] args) {
		
		divide(x, y);
		divideOptimized(x, y);
	}

	public static void divideOptimized(int divident,int divisor){
		int totalIterations = 0;
		int currQuotientBase=1;
		int currDivisor=divisor;
		int sign = (divident*divisor < 0)? -1 : 1;
		
		int quotient=0;
		int remainder=0;
		
		while(divident>=divisor){
			if(divident>=currDivisor){
				divident=divident-currDivisor;
				quotient = quotient + currQuotientBase;
				currDivisor=currDivisor*2;
				currQuotientBase=currQuotientBase*2;
			}
			else{
				currDivisor=currDivisor/2;
				currQuotientBase=currQuotientBase/2;
			}
			totalIterations++;
		}
		remainder=divident;
		totalIterations = totalIterations  * sign;
		System.out.println("Quotient: " + quotient + ", remainder: " + remainder + " [" + totalIterations + "]");
	}
	
	public static void divide(int divident,int divisor){
		int totalIterations = 0;
		
		int quotient=0;
		int remainder=0;
		int sign = (divident*divisor < 0)? -1 : 1;
		
		while(divident>0){
			divident=divident-divisor;
			quotient++;
			if(divident<divisor){
				remainder=divident;
				divident=0;
			}
			totalIterations++;
		}
		totalIterations = totalIterations  * sign;
		System.out.println("Quotient: " + quotient + ", remainder: " + remainder + " [" + totalIterations + "]");
	}

}
