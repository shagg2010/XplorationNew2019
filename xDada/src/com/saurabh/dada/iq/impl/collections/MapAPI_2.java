package com.saurabh.dada.iq.impl.collections;

import java.util.HashMap;
import java.util.Hashtable;

public class MapAPI_2 {

	public static void main(String[] args) {
		
		try{
			HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
			hashMap.put(null, null);
			hashMap.put(null, "null");
			hashMap.put(null, "abc");
			hashMap.put(1, null);
			hashMap.put(1, "xyz");
			System.out.println("hashMap: " + hashMap);
		}
		catch(NullPointerException ne){
			System.out.println("Null key/value not allowed in HashMap.");
		}
		catch(Exception e){
			System.out.println("Some exception!!");
		}
		
		try{
			Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>();
			hashTable.put(1, null);
			hashTable.put(1, "xyz");
			hashTable.put(null, null);
			hashTable.put(null, "abc");
			System.out.println("hashTable: " + hashTable);
		}
		catch(NullPointerException ne){
			System.out.println("Null key/value not allowed in Hashtable. Exception: " + ne.toString()+"\n");
			ne.printStackTrace();
		}
		catch(Exception e){
			System.out.println("Some exception!!");
		}

	}

}
