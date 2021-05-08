package com.yadas.code.java.ds;

public class Number
{ 
	static{
		System.out.println("Class Loaded: " + Number.class.getCanonicalName());
	}
	public static void main(String[] args)
    { 
        System.out.println("It works"); 
    } 
} 

class String //rename to String
{ 
	
	public static void main(String[] args)//compiler sees "String[] args" as is com.yadas.code.java.ds.String 
	//class instead of java.lang.String, hence it says main method not found
	//rename method signature to public static void main(java.lang.String[] args) and it will start working
	{ 
        System.out.println("It works"); 
        Example e = new Example();
        Example e1 = new Example(e);
    } 
} 

class Example {

    private String value;

    public Example() {
    }

    public Example(Example e){
        value = e.getValue();
    }

    String getValue() {
        return value;
    }
}