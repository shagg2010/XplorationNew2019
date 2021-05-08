package com.saurabh.dada.iq.impl.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerearth.com/problem/algorithm/what-is-the-string-made-of-2/description/
 * @author yadas
 *
 */
public class CountNumberOfDashesInString {
	
	private static final Map<Character, Integer> map=new HashMap<Character, Integer>();
	//private static byte[] dashes = new byte[10];
	
	static{
		map.put('0', 6); map.put('1', 2); map.put('2', 5); map.put('3', 5); map.put('4', 4);
		map.put('5', 5); map.put('6', 6); map.put('7', 3); map.put('8', 7); map.put('9', 6);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(countDashes(line));
	}
	
	public static int countDashes(String str){
		int sum=0;
		Integer val = null;
		for(int i=0;i<str.length();i++){
			val = map.get(str.charAt(i));
			//System.out.println("str.charAt(i): " + val);
			if(val!=null)
				sum=sum+val;
		}
		return sum;
	}

}
