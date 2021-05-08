package com.saurabh.dada.iq.impl.designpatterns.servicelocator;

public class InitialContext {
	   
	public Object lookup(String jndiName){
	   
	      if(jndiName.equalsIgnoreCase("SERVICE1")){
	         System.out.println("Looking up and creating a new Service1 object");
	         return Service1.getInstance();
	      }
	      else if (jndiName.equalsIgnoreCase("SERVICE2")){
	         System.out.println("Looking up and creating a new Service2 object");
	         return Service2.getInstance();
	      }
	      return null;		
	   }
}
