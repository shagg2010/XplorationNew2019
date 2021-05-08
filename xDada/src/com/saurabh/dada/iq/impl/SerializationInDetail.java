package com.saurabh.dada.iq.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationInDetail {

	public static void main(String[] args) {
		
		Address address = new Address();
		address.setStreet("wall street");
		address.setCountry("united states");

		writeObject(address);
		readObject(address);
	}

	public static void readObject(Address address) {
		try {
			// read object
			FileInputStream fin = new FileInputStream("address.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			address = (Address) ois.readObject();
			ois.close();
			
			System.out.println("reading done: " + address + "\nhashCode: " + address.hashCode());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeObject(Address address) {
		try {
			// write object
			FileOutputStream fout = new FileOutputStream("address.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(address);
			oos.close();
			System.out.println("writing done..." + "\nhashCode: " + address.hashCode());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Address implements Serializable{
	 
	   private static final long serialVersionUID = 2L;
	
	   String street;
	   String country;

	   public void setStreet(String street){
		   this.street = street;
	   }

	   public void setCountry(String country){
		   this.country = country;
	   }

	   public String getStreet(){
		   return this.street;
	   }

	   public String getCountry(){
		   return this.country;
	   }

	   @Override
	   public String toString() {
 	   return new StringBuffer(" Street : ")
 	   .append(this.street)
 	   .append(" Country : ")
 	   .append(this.country).toString();
	   }
}