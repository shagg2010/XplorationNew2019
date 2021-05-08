package com.saurabh.dada.iq.impl.gfg;

import java.util.HashMap;
import java.util.Map;

public class Array_PairsSumEqualToN {

	private static int[] ITEMS = {7,1,2,8,3,4,0,5,6,1};
	private static int sum=8;
	
	public static void main(String[] args) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i:ITEMS){
			if(!map.containsKey(i))
				map.put(i, 1);
			else{
				int count = map.get(i);
				count++;
				map.put(i, count);
			}
		}
		
		for(int i:ITEMS){
			int d=sum-i;
			if(map.containsKey(d)&&d!=i){
				System.out.println(i+","+d);
				map.remove(i);
			}
				
		}
		
	}

}
