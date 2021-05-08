package com.saurabh.dada.iq.impl;

public class StockBuySellToMaximizeProfit {

	public static void main(String[] args) {
		int A[] = {100, 180, 260, 310, 40,40, 535, 695};
		//int A[] = {100, 90, 80, 70, 60, 30, 20,21};

	    int min = A[0]; // Lets assume first element is minimum
	    int maxProfit = Integer.MIN_VALUE; // 0 profit, if we buy & sell on same day.
	    int profit = 0;
	    int minIndex = 0; // Index of buy date
	    int maxIndex = 0; // Index of sell date

	    //Run the loop from next element
	    for (int i = 1; i < A.length; i++) {
	        //Keep track of minimum buy price & index
	        if (A[i] <= min) {
	            min = A[i];
	            minIndex = i;
	        }
	        //System.out.println("min: " + min);
	        profit = A[i] - min;
	        //If new profit is more than previous profit, keep it and update the max index
	        if (profit > maxProfit) {
	            maxProfit = profit;
	            maxIndex = i;
	        }
	        //System.out.println("max: " + A[maxIndex]);
	    }
	    if(maxProfit>0){
	    	System.out.println("maxProfit is "+maxProfit);
		    System.out.println("buy @ "+ (minIndex+1) + " day");
		    System.out.println("sell @ "+ (maxIndex+1) + " day");
	    }
	    else{
	    	System.out.println("No day where we can earn profit!");
	    }

	}

}
