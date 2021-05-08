package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.List;

public class CloneUsage {

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneableClass cc1 = new CloneableClass("cc1", 1, new Property(1, "p1"));
		CloneableClass cc2 = cc1.clone();
		
		System.out.println("cc1: " + cc1);
		System.out.println("cc2: " + cc2);
		
		cc1.getProperty().setVal(2); //this changes both
		cc1.getProperty().setStr("p2");//this changes both
		
		System.out.println("cc1: " + cc1);
		System.out.println("cc2: " + cc2);
		
		System.out.println("cc1.hashCode(): " + cc1.hashCode());
		System.out.println("cc2.hashCode(): " + cc2.hashCode());
		
		System.out.println("cc1.property==cc2.property: " + (cc1.getProperty()==cc2.getProperty()));
		System.out.println("cc1.classId==cc2.classId: " + (cc1.classId==cc2.classId));
		
		System.out.println("cc1==cc2:" + (cc1==cc2));
		System.out.println("cc1.equals(cc2):" + (cc1.equals(cc2)));
		
		System.out.println("cc1.property.hashCode: " + cc1.getProperty().hashCode());
		System.out.println("cc2.property.hashCode: " + cc2.getProperty().hashCode());

		
	}

}

class CloneableClass implements Cloneable{
	public String classId;
	private int value;
	private Property property;
	private List<String> list;
	
	public CloneableClass(String classId, int value, Property property) {
		super();
		this.classId = classId;
		this.value = value;
		this.property = property;
		list = new ArrayList<String>(10);
		for(int i=0;i<10;i++)
			list.add((i+1)+"");
	}
	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "CloneableClass [classId=" + classId + ", value=" + value + ", property=" + property + ", list=" + list + "]";
	}
	protected CloneableClass clone() throws CloneNotSupportedException{
		return (CloneableClass) super.clone();
	}
}
class Property{
	private int val = 0;
	private String str;
	
	public Property(int val, String str) {
		super();
		this.val = val;
		this.str=str;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Property [val=" + val + ", str=" + str + "]";
	}
	
}
