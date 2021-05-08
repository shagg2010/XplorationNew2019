package com.saurabh.dada.iq.impl.gfg;

import java.util.HashMap;
import java.util.Map;

public class Array_MajorityElement {
	
	private static int[] ITEMS1 = {3,3,4,2,4,4,2,4,4};
	private static int[] ITEMS2 = {3,3,4,2,4,4,2,4};

	public static void main(String[] args) {
		Map<Integer, Double> map = new HashMap<>();
		boolean flag=false;
		for(int i: ITEMS2){
			if(!map.containsKey(i))
				map.put(i, 1.0d);
			else{
				double count=map.get(i);
				count++;
				if(count>((double)ITEMS2.length/2.0d)){
					System.out.println(i);
					flag=true;
					break;
				}
				map.put(i, count);
			}
		}
		//System.out.println(map + " " + ((double)ITEMS2.length/2.0d));
		if(!flag){
			System.out.println("NONE");;
		}
	}

}
