package com.saurabh.dada.iq.impl;

public class ClassLoadingAndInitialization_StaticNonStaticBlocks {

	public static void main(String[] args) {
		
		//Please read the second example of - http://javarevisited.blogspot.in/2012/07/when-class-loading-initialization-java-example.html
		//----initialization occurs because static field is accessed which is not a compile time constant. had you declare "familyName" compile time 
		//----constant using final keyword in Java (as shown in commented section) class initialization of super class would not have occurred.

		NotUsed nu = null;
		System.out.println("-------------------------------");
		Parentz p = new Childz();
		System.out.println("-------------------------------");
		Parentz p1 = new Parentz();
		System.out.println("-------------------------------");
		new Main() {{
            System.out.println("Anonymous initalizer block");
        }};
        
	}

}
class Parentz {
    static { System.out.println("static block of Super class is initialized"); }
    {System.out.println("non static blocks in super class is initialized");}
    public Parentz(){
    	System.out.println("constructor for super");
    }
    {System.out.println("non static blocks in super class is initialized - after constructor");}
}

class Childz extends Parentz {
    static { System.out.println("static block of Sub class is initialized in Java "); }
    {System.out.println("non static blocks in sub class is initialized");}
    public Childz(){
    	System.out.println("constructor for super");
    }
}

class NotUsed {
    static { System.out.println("NotUsed Class is initialized "); }
}

class Main extends SuperClass {
    {
        System.out.println("Initialiser block before constructor");
    }

    Main() {
        System.out.println("Main constructor");
    }

    {
        System.out.println("Initialiser block after constructor");

    }

}

class SuperClass {
    SuperClass() {
        System.out.println("SuperClass constructor");
    }
}