package com.saurabh.dada.iq.impl.iq.accolite;

public class Questions {
	
	public static void main(String[] args) {
		integerInstances();
		
	}
	
	public static void integerInstances(){
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		
		System.out.println();
		System.out.println(i1==i2);
		System.out.println(i1!=i2);
		
		System.out.println();
		System.out.println(i1>=i2);
		System.out.println(i1<=i2);
		
		System.out.println("-------------------------");
		Integer i3 = 1;
		Integer i4 = 1;
		
		System.out.println(i3.hashCode());
		System.out.println(i4.hashCode());
		
		System.out.println();
		System.out.println(i3==i4);
		System.out.println(i3!=i4);
		
		System.out.println();
		System.out.println(i3>=i4);
		System.out.println(i3<=i4);

	}

}
