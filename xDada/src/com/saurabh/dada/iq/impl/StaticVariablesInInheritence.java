package com.saurabh.dada.iq.impl;

public class StaticVariablesInInheritence {

	public static void main(String[] args) {
		
		B2 b = new B2();
		 
        System.out.println(b.i);

	}

}
class A2
{
    static int i = 1111;
 
    static
    {
    	System.out.println("1a.i: " + i);
        i = i-- - --i;  // 1111 - 1110 = 1 
        				//0
        System.out.println("1a.i: " + i);
    }
 
    {
        i = i++ + ++i;
        System.out.println("2a.i: " + i);
    }
    
    public A2(){
    	System.out.println("A2...");
    }
}
 
class B2 extends A2
{
    static
    {
        i = --i - i--; // -1 - (-1) = 0
        				//-1
        System.out.println("1b.i: " + i);
    }
 
    {
        i = ++i + i++;
        System.out.println("2b.i: " + i);
    }
    
    public B2(){
    	System.out.println("B2...");
    }
}
