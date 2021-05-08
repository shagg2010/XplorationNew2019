package com.saurabh.dada.iq.impl;

public class DataMemberInheritence {

	public static void main(String[] args) {
		
		Parent parent = new Parent();
		System.out.println(parent.surname);
		System.out.println(parent.getSurname());
		
		System.out.println("--------------------");
		parent = new Child();
		System.out.println(parent.surname); //gets the data member for parent because object type is parent
		System.out.println(parent.getSurname());

	}

}

class Parent{
	public String surname = "Yaduvanshi";

	public String getSurname() {
		return this.surname;
	}
}

class Child extends Parent{
	public String surname = "Yadav";
	
	public String getSurname() {
		return surname;
	}
}
