package com.saurabh.dada.iq.impl.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class MapAPI {

	public static void main(String[] args) {
		try{
			String[] items = CollectionData.mapData.split(" ");
			Map<String,Integer> map = new HashMap<String,Integer>();
			Integer ONE = new Integer(1);
			for(int i=0,n=items.length;i<n;i++){
				String key = items[i];
				Integer frequency = map.get(key);
				if(frequency==null){
					frequency = ONE;
				}
				else{
					frequency = new Integer(frequency.intValue()+1);
				}
				map.put(key, frequency);
			}
			System.out.println("map:" + map);
			Map<String, Integer> sortedMap = new TreeMap<String, Integer>(map);
			System.out.println("sortedMap:" + sortedMap);
			
			HashMap<Integer, SomeData2> sMap = new HashMap<Integer, SomeData2>();
			for(SomeData2 data: CollectionData.sData2){
				sMap.put(data.getCaseId(), data);
			}
			System.out.println("sMap: "+sMap);
			
			Hashtable<String, String> tab = new Hashtable<String, String>();
			HashMap<String, String> tab2 = new HashMap<String, String>();
			tab2.put(null, null);
			tab.put(null, null);// null key/values not allowed therefore NPE is reported
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
