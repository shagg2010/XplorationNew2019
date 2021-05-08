package com.saurabh.dada.iq.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class RahulSharma<K, V> {

	private K k;
	private V v;
	
	public K getK() {
		return k;
	}
	public void setK(K k) {
		this.k = k;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
	@Override
	public String toString() {
		return "RahulSharma [k=" + k + ", v=" + v + "]";
	}
	public static void main(String[] args) {
		
		try {
			Class c = Class.forName("java.lang.String");
			try {
				Object obj = c.getConstructor(String.class).newInstance("Hello World!");
				System.out.println(obj);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(c.getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(RahulSharma.class.getClassLoader());
		//permutations("", "ashirya");
		System.exit(0);
		RahulSharma<Integer, String> rs = new RahulSharma<>();
		rs.setK(new Integer(1));
		rs.setV("One");
		System.out.println("RahulSharma: " + rs);
		
		
		RahulSharma<String, List<Integer>> rs1 = new RahulSharma<>();
		rs1.setK("1..10");
		List<Integer> list = (List<Integer>) Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		rs1.setV(list) ;
		System.out.println(rs1);
	}

	private static void permutations(String perm, String word) {
		if(word.isEmpty()) {
			System.out.println(perm);
		}
		else {
			for(int i=0;i<word.length();i++) {
				permutations(perm + word.charAt(i), word.substring(0, i) + word.substring(i+1,word.length()));
			}
		}
	}
	
}
