package com.saurabh.dada.iq.impl.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetAPI {

	public static void main(String[] args) {
		
		String[] list = CollectionData.setlist;
		
		try{
			for(String item:list){
				if(item!=null)
					System.out.print(item + "     \thash: " + item.hashCode()+"\n");
				else
					System.out.print("null     \thash: " +"?\n");
			}
			Set<String> set = new HashSet<String>();
			for(String item:list){
				set.add(item);
			}
			set = Collections.synchronizedSet(set);
			System.out.println("HashSet: " + set);
			boolean flag1 = set.contains("Saurabh");
			System.out.println(flag1);
			
			//TreeSet does not allow nulls because its elements must implement Comparable interface and thus the value should not be null
			Set<String> sortedSet = new TreeSet<String>();
			for(String item:list){
				if(item!=null)
					sortedSet.add(item);
			}
			System.out.println("TreeSet: " + sortedSet);
			
			Set<String> linkedSet = new LinkedHashSet<String>();
			for(String item:list){
				linkedSet.add(item);
			}
			System.out.println("LinkedSet: " + linkedSet);
			
			
			boolean flag3 = sortedSet.equals(set);
			System.out.println("set==sortedSet: " + flag3);
			boolean flag4 = linkedSet.equals(set);
			System.out.println("set==linkedSet: " + flag4);
	
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
