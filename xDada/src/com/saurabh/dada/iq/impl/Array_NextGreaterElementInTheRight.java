package com.saurabh.dada.iq.impl;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.saurabh.dada.iq.impl.algos.sort.QuickSortInvalid;

public class Array_NextGreaterElementInTheRight {
	
	private static int[] list = {4 ,5 ,2 ,25,20,11,21,13,23,3 }; // ={5 ,25,25,-1,21,21,23,23,-1,-1}
							  //{11,6,34,1,70,4,18,3,21,0,13}; //={34,34,70,70,-1,18,21,21,-1,13,-1}
								
	public static void main(String[] args) {
		
		long start =System.nanoTime();
		//QuickSortInvalid.displayArray(list);
		//findNGE_Vipin(list);
		
		int[] nge = new int[list.length];
		Set<Integer> setOfAllBigValuesInRight = new TreeSet<Integer>();
				
		for(int i=list.length-1;i>=0;i--){
			//System.out.println("["+i+"] - setOfAllBigValuesInRight: " + setOfAllBigValuesInRight + " size:" + setOfAllBigValuesInRight.size());
			if(setOfAllBigValuesInRight.size()==0){
				nge[i]=-1;
			}
			if(setOfAllBigValuesInRight.size()>0){
				Iterator<Integer> it = setOfAllBigValuesInRight.iterator();
				while(it.hasNext()){
					Integer v = it.next();
					if(v<=list[i]){
						it.remove();
					}
				}
				//System.out.println("[r] - setOfAllBigValuesInRight: " + setOfAllBigValuesInRight);
				if(setOfAllBigValuesInRight.size()==0){
					nge[i]=-1;
				}
				else
					nge[i]=setOfAllBigValuesInRight.iterator().next();
			}
			Integer curr= new Integer(list[i]);
			setOfAllBigValuesInRight.add(curr);
		}
		System.out.println("time taken: " + (System.nanoTime() - start));
		QuickSortInvalid.displayArray(nge);
	}
	
	public static void findNGE_Vipin(int[] input) {
		int te = input.length - 1;
		int max = -1;
		int re = -1;
		for (int k = te; k >= 0; k--) {
			if (k == input.length - 1) {
				System.out.println("Element " + input[k] + " highest is" + re);
				// max=input[k];
				continue;
			} else {
				if (input[k] < max) {
					System.out.println("Element " + input[k] + " highest is"
							+ max);
				} else {
					max = input[k];
					System.out.println("Element " + input[k] + " highest is"
							+ re);
				}
			}
		}
	}
	public static void getAllBigValuesInRight(int[] list, int offset,Set<Integer> setOfAllBigValuesInRight){
		
	}

}
