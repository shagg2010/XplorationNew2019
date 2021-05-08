package com.saurabh.dada.iq.impl;

import java.util.HashMap;
import java.util.Map;

public class HashMap_Miscellaneous {
	
	public static void main(String[] args){
		try{
			
			String a1="a1";
			String a2="a2";
			String a3=new String("a1");
			
			System.out.println("a1.hashCode(): "+a1.hashCode());
			System.out.println("a2.hashCode(): "+a2.hashCode());
			System.out.println("a3.hashCode(): "+a3.hashCode());
			
			System.out.println("a1.equals(a2): "+a1.equals(a2));
			System.out.println("a1.equals(a3): "+a1.equals(a3));
			
			System.out.println("a1==a2: "+(a1==a2));
			System.out.println("a1==a3: "+(a1==a3));
			
			HashMap<String, String> hashMap = new HashMap<String,String>();
			hashMap.put(a1, a1);
			hashMap.put(a2, a2);
			hashMap.put(a3, a3);
			
			System.out.println("\n"+hashMap);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
interface IData{
	public String getData();
}
class Data implements IData{

	private String data;
	
	public Data(String data){
		this.data = data;
	}
	
	@Override
	public String getData() {
		return this.data;
	}
	
}

class MapEQ {

	  public static void main(String[] args) {
	   Map<ToDos, String> m = new HashMap<ToDos, String>();
	   ToDos t1 = new ToDos("Monday");
	   ToDos t2 = new ToDos("Monday");
	   ToDos t3 = new ToDos("Tuesday");
	   m.put(t1, "doLaundry");
	   m.put(t2, "payBills");
	   m.put(t3, "cleanAttic");
	   System.out.println(m);
	   System.out.println(m.size());
	} }

	class ToDos{

	  String day;

	  ToDos(String d) { day = d; }

	 public boolean equals(Object o) {
	      return ((ToDos)o).day.equalsIgnoreCase(this.day);
	 } 
	  public String toString(){
		  return this.day;
	  }

	public int hashCode() { return this.day.hashCode(); }
	}