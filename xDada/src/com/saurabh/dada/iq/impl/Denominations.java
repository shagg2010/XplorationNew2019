package com.saurabh.dada.iq.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Denominations {

	//assume or sort coins in descending order
	public static int[] coins = {15,10,5,2,1};
	public static int amount = 101;
	
	 // m is size of coins array (number of different coins) 
    static int minCoins(int coins[], int m, int V) 
    { 
       // base case 
       if (V == 0) return 0; 
       
       // Initialize result 
       int res = Integer.MAX_VALUE; 
       
       // Try every coin that has smaller value than V 
       for (int i=0; i<m; i++) 
       { 
         if (coins[i] <= V) 
         { 
             int sub_res = minCoins(coins, m, V-coins[i]); 
       
             // Check for INT_MAX to avoid overflow and see if 
             // result can minimized 
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) 
                res = sub_res + 1; 
         } 
       } 
       return res; 
    } 

	public static void main(String[] args) {
		
		int result = minCoins(coins,coins.length,amount);
		
		System.out.println("Min Coins: " + result);
		TreeSet<Integer> cns = new TreeSet<Integer>();
		for(int c:coins)
			cns.add(new Integer(c));
		Integer[] coins1=new Integer[coins.length];
		cns.toArray(coins1);
		for(int i=0,j=coins.length-1;i<coins.length;i++,j--)
			coins[i]=coins1[j];
		
		Map<Integer,Map<Integer,Integer>> ans = getDenominations(coins, amount);
		System.out.println("All Possible Combinations: " + ans);
		Set<Integer> set = ans.keySet();
		Integer minKey = (Integer) set.toArray()[0];
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			Integer key = it.next();
			if(key<minKey)
				minKey=key;
		}
		System.out.println("Minimum Denomincations: " + minKey + ", Ans: " + ans.get(minKey));

	}
	
	public static Map<Integer,Map<Integer,Integer>> getDenominations(int[] coins,int amount){
		
		Map<Integer,Map<Integer,Integer>> ans = new HashMap<Integer, Map<Integer,Integer>>();
		//check complete divisibilty
		for(int ci=0;ci<coins.length;ci++){
			int c=coins[ci];
			if(getRemainder(c, amount)==0){
				Map<Integer,Integer> result=new HashMap<Integer, Integer>();
				result.put(new Integer(c),new Integer(amount/c));
				//System.out.println("One:" + result);
				ans.put(new Integer(amount/c), result);
			}
			else{
				int remainder=amount;
				int totalDenominations=0;
				int i=ci;
				Map<Integer,Integer> resultSet=new HashMap<Integer, Integer>();
				while(remainder!=0 && i<coins.length){
					int q=getQuotient(remainder, coins[i]);
					if(q>0){
						int denominations = getQuotient(remainder, coins[i]);
						totalDenominations = totalDenominations + denominations;						
						remainder=getRemainder(coins[i], remainder);					
						resultSet.put(new Integer(coins[i]), new Integer(denominations));
					}					
					i++;
				}
				ans.put(new Integer(totalDenominations), resultSet);
				//System.out.println("Multiple:" + resultSet);
			}
		}
		return ans;
	}
	
	public static int getRemainder(int n1,int n2){
		return n2%n1;
	}
	
	public static int getQuotient(int n1,int n2){
		return n1/n2;
	}

	/*public static int getRemainingDenominations(int amt, int[] cs,int ccoin){
		TreeSet<Integer> cns = new TreeSet<Integer>();
		for(int c:cs){
			if(ccoin!=c)
				cns.add(new Integer(c));
		}
			
		Integer[] coins;
		cns.toArray(coins);
		System.out.println(coins);
		int totalDenominations=0;
		int remainder=amt;
		int i=0;
		while(remainder!=0 && i<coins.length){
			int q=getQuotient(remainder, coins);
			if(q>0){
				int denominations = getQuotient(remainder, coins[i]);
				totalDenominations = totalDenominations + denominations;						
				remainder=getRemainder(coins[i], remainder);					
				resultSet.put(new Integer(coins[i]), new Integer(denominations));
			}					
			i++;
		}
		
		return totalDenominations;
	}*/
	
}
