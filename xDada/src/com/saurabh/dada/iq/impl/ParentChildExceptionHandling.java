package com.saurabh.dada.iq.impl;

public class ParentChildExceptionHandling {

	/* 1) Rule: If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception.  */
	/* 2) Rule: If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception 
	 *    but can declare unchecked exception. */

}
class Parent1{  
	  void msg(){System.out.println("parent");}  
	}  
	  
class TestExceptionChild extends Parent1{  
	  void msg() throws ArithmeticException /* throws IOException - this is not allowed*/{  
	    System.out.println("TestExceptionChild");  
	  }  
	  public static void main(String args[]){  
	   Parent1 p=new TestExceptionChild();  
	   p.msg();  
	  }  
}  
