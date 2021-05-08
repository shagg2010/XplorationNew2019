package com.saurabh.java.hfsj.ch08.models;

public class Person implements IPerson {
	
	private static final long serialVersionUID = 2527365956711382500L;
	
	private String name;
	private byte age;
	
	public Person(){
		super();
	}
	
	public Person(String name, byte age) {
		super();
		this.name = name;
		this.age = age;
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
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
