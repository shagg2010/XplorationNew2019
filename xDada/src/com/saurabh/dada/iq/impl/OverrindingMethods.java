package com.saurabh.dada.iq.impl;

class ParentBase {
    
    // Static method in base class which will be hidden in subclass 
    public static void display() {
        System.out.println("Static or class method from Base");
    }
     
     // Non-static method which will be overridden in derived class 
     public void print()  {
         System.out.println("Non-static or Instance method from Base");
    }
     
     public static void main(String args[ ])  {
    	 System.out.println("In Base's main method");
     }
}
 
// Subclass
class Children extends ParentBase {
     
    // This method hides display() in Base 
    public static void display() {
         System.out.println("Static or class method from Derived");
    }
     
    // This method overrides print() in Base 
    public void print() {
         System.out.println("Non-static or Instance method from Derived");
   }
    
    public static void main(String args[ ])  {
   	 System.out.println("In Derived's main method");
    }
}
 
// Driver class
public class OverrindingMethods {
    public static void main(String args[ ])  {
       Children child = new Children();
        ParentBase parent = child;
       // As per overriding rules this should call to class Derive's static 
       // overridden method. Since static method can not be overridden, it 
       // calls Base's display() 
        parent.display();  
        
       // Here overriding works and Derive's print() is called 
        child.print();
       
        parent.main(null);
       
    }
}