package com.saurabh.java.hfsj.ch08.models;

import java.util.Arrays;

public class Person3 implements IPerson{
	
	private static final long serialVersionUID = 7719435864920831221L;
	
	private String name;
	private byte age;
	private String[] hobbies;
	
	
	@Override
	public String toString() {
		return "Person3 [name=" + name + ", age=" + age + ", hobbies="
				+ Arrays.toString(hobbies) + "]";
	}
	public Person3() {
		super();
	}
	public Person3(String name, byte age, String[] hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
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
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

}
