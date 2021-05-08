package com.saurabh.dada.iq.impl;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Doubts {


	public static void main(String[] args) throws Exception {
		
		/*for(int i=27;i<20000;i++){
			System.out.println("insert into INPUT_DATA_TABLE values("+i+","+(i+10)+","+(i+5)+");");
		}*/
		
		A11 a11 = new A11();
		System.out.println(a11.VALUE);
		a11 = new B11();
		System.out.println(a11.VALUE);
		B11 b11 = new B11();
		b11.method();
		
		String str = "abcde";
		StringBuilder sb = new StringBuilder(str.substring(1) + str.charAt(0));
		System.out.println(sb);
		
		str = sb.substring(sb.length()-1).concat(sb.substring(0,sb.length()-1));
		System.out.println(str);
		
		System.exit(0);
		
		foo(true,true);
		
		Long val = new Long(123L);
		Set<Long> set = new HashSet<Long>();
		set.add(val);
		set.add(new Long(124L));
		System.out.println(set.contains(new Long(123L)));
		
		System.out.println(set);
		
		for(int i=0;i<500;i++)
			System.out.println(java.util.UUID.randomUUID());
		
		System.out.println(InetAddress.getByName("lyadasw7.rpega.com"));
		for(int i=0;i<1;i++){
			System.out.println((i+1)%27);
		}

		LinkedList<Integer> ll = new LinkedList<>();
		ll.size();
	}

	public static void foo( boolean a, boolean b)
	{ 
	    if( a ) 
	    {
	        System.out.println("A"); /* Line 5 */
	    } 
	    else if(a && b) /* Line 7 */
	    { 
	        System.out.println( "A && B"); 
	    } 
	    else /* Line 11 */
	    { 
	        if ( !b ) 
	        {
	            System.out.println( "notB") ;
	        } 
	        else 
	        {
	            System.out.println( "ELSE" ) ; 
	        } 
	    } 
	}
}
class A11{
	public static int VALUE=1;
}

class B11 extends A11{
	public void method(){
		System.out.println(VALUE);
	}
}
