package com.saurabh.dada.iq.impl;

public class ClassLoaderInJava {

	private ClassLoaderInJava() {
	}
	 public static void main(String[] args) throws InstantiationException, IllegalAccessException {

	      try {
	         Class cls = Class.forName("com.saurabh.dada.iq.impl.Load");

	         // returns the ClassLoader object
	         ClassLoader cLoader = cls.getClassLoader();
	         
	         Object obj = cls.newInstance();
	         System.out.println(obj);
	         ((com.saurabh.dada.iq.impl.Load)obj).method();
	       
	         /* returns the Class object associated with the class or interface 
	            with the given string name, using the given classloader. */
	         Class cls2 = Class.forName("java.lang.Thread", true, cLoader);       
	          
	         // returns the name of the class
	         System.out.println("Class = " + cls.getName() + "\tclassloader: " + cls.getClassLoader() + "\t parent classloader: " + cls.getClassLoader().getParent());
	         System.out.println("Class = " + cls2.getName() + "\tclassloader: " + cls2.getClassLoader() + "\t parent classloader: " + cls.getClassLoader().getParent() + "\t parent classloader: " + cls.getClassLoader().getParent()); 
	      } catch(ClassNotFoundException ex) {
	         System.out.println(ex.toString());
	      }
	   }
	 
	 public void method() {
		 System.out.println("Method");
	 }
}

class Load {
    public Load() {}
     
    public void method() {
		 System.out.println("Method");
	 }
}
