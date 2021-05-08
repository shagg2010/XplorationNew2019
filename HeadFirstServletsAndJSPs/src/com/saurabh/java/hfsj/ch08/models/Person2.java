package com.saurabh.java.hfsj.ch08.models;

public class Person2 implements IPerson {
	
	private static final long serialVersionUID = -4679885290669883652L;
	private String name;
	private byte age;
	private Dog pet;
	
	public Dog getPet() {
		return pet;
	}

	public void setPet(Dog pet) {
		this.pet = pet;
	}

	public Person2(){
		super();
	}
	
	public Person2(String name, byte age, Dog pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person2 [name=" + name + ", age=" + age + ", pet=" + pet + "]";
	}
	
}
