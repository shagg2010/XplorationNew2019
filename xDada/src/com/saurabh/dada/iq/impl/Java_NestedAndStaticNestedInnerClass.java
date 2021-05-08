package com.saurabh.dada.iq.impl;

public class Java_NestedAndStaticNestedInnerClass {

	//http://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
	
	public static void main(String[] args) {
		
		//to create object of Static Inner class 
		OuterClass.StaticInnerClass nestedObject = new OuterClass.StaticInnerClass();
		OuterClass.StaticInnerClass.StaticInnerInnerClass nestednestedObject = new OuterClass.StaticInnerClass.StaticInnerInnerClass();

		//to create object of Inner class 
		OuterClass outerObject = new OuterClass();
		OuterClass.InnerClass innerObject = outerObject.new InnerClass();
	}

}

class OuterClass {
    
    public class InnerClass {
        
    }
    
    public static class StaticInnerClass {
    	
    	public static class StaticInnerInnerClass {
    		
    	}
        
    }
}

