package com.saurabh.dada.iq.impl;

public class NullReturnInPrimitiveDataType {

	public static void main(String[] args) {
		
		int i = 10 + + 11 - - 12 + + + 13 - - 14 + + 15;
		 
        System.out.println(i);
        
        Integer i1 = 127;        
        Integer i2 = 127;
        
        System.out.println(i1 == i2); //true because till 127 Integer class cache the numbers and returns the same instance, we can change is limit by using jvm argument
 
        Integer i3 = 128; 
        Integer i4 = 128;

        System.out.println(i3 == i4);

		System.out.println(A3.methodOne(11));
		A3 a3 = new A3();
		a3.methodOfA();
		
	}

}
class A3
{
    public int methodOfA()
    {    	
        return (true ? null : 0);
    }
    
    static int methodOne(int i)
    {
        return methodTwo(i *= 11);
    }
 
    static int methodTwo(int i)
    {
        return methodThree(i /= 11);
    }
 
    static int methodThree(int i)
    {
        return methodFour(i -= 11);
    }
 
    static int methodFour(int i)
    {
        return i += 11;
    }
}
