package com.saurabh.dada.iq.impl;

import java.util.Arrays;

public class TryCatchWithSystemExit {

	public static void main(String[] args) {

		double val = 1.0d/0.0d;
		System.out.println(val);
		
		char[] chars = new char[] {'\u0097'};
        String str = new String(chars);
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
		
		System.out.println(method());
		System.out.println("-----------");
		System.out.println(method2());

	}
	
	public static Integer method(){
		try{
			System.out.println("Before return!");
			return new Integer(10);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("In finally block!");
		}
		return new Integer(10);
	}
	
	public static Integer method2(){
		try{
			System.out.println("Before System.exit!");
			System.exit(0);
			System.out.println("After System.exit!");
			return new Integer(10);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("In finally block!");
		}
		return new Integer(10);
	}

}
