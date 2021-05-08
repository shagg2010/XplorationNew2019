package com.saurabh.dada.iq.impl.xml.obj;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customer",namespace = "com.saurabh.xml.jaxb.model")
public class Customer {
	
	private String name;
	private int age;
	private int id;
	
	public Customer(){
		//do nothing - required for JAXB
	}
	
	public Customer(int id,String name){
		this();
		this.id=id;
		this.name=name;
	}
	
	public Customer(int id,String name,int age){
		this(id,name);
		this.age=age;
	}
	
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
