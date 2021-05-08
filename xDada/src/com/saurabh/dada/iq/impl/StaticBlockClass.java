package com.saurabh.dada.iq.impl;

public class StaticBlockClass {
	
	static{
		System.out.println("Static Block...!");
	}
	
	public static final void main(String args[]) throws Exception{
		System.out.println("main method...!");
		StaticBlockChildClass.someMethod();
		StaticBlockChildClass sbcc = new StaticBlockChildClass();
	}
	
	static class StaticBlockChildClass{
		
		{
			System.out.println("Block 1");
		}
		static{
			System.out.println("StaticBlockChildClass - > Static Block...!");
		}
		{
			System.out.println("Block 2");
		}
		
		public StaticBlockChildClass(){
			System.out.println("StaticBlockChildClass -> Constructor...!");
		}
		
		public static void someMethod(){
			System.out.println("StaticBlockChildClass -> someMethod...!");
		}
	}

}


