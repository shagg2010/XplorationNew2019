package com.saurabh.dada.iq.impl;

public class Arrays_MaxDifferenceBetweenElementsInArray_SharesProfit {

	public static void main(String[] args) {
		int[] stock_price = {5, 1, 4, 6, 7, 8, 4, 3, 7, 9};
		//int[] stock_price = {10,9,8,7,6,5};
		//ans is 9-1 = 8 (max difference)
		int res = getMaxBenefit(stock_price);
		if(res==0)
			System.out.println("No day where we can earn profit");
		else
			System.out.println("Max benefit: " + res);
	}
	
	public static int getMaxBenefit(int[] prices) {
		int maxBenefit = Integer.MIN_VALUE;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++){
			minPrice = Math.min(minPrice, prices[i]);
			maxBenefit = Math.max(maxBenefit, prices[i] - minPrice);
			System.out.println("minPrice: " + minPrice + ", maxBenefit: " + maxBenefit);
		}
		return maxBenefit;

	}

}
