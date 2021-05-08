package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableVsComparator {

	public static void main(String[] args) {
		HDTV tv1 = new HDTV(55, "Samsung");
		HDTV tv2 = new HDTV(60, "Sony");
 
		if (tv1.compareTo(tv2) > 0) {
			System.out.println(tv1.getBrand() + " is better.");
		} else {
			System.out.println(tv2.getBrand() + " is better.");
		}
		
		HDTVv2 tv11 = new HDTVv2(55, "Samsung");
		HDTVv2 tv22 = new HDTVv2(60, "Sony");
		HDTVv2 tv33 = new HDTVv2(42, "Panasonic");
 
		ArrayList<HDTVv2> al = new ArrayList<HDTVv2>();
		al.add(tv11);
		al.add(tv22);
		al.add(tv33);
 
		Collections.sort(al, new SizeComparator());
		for (HDTVv2 a : al) {
			System.out.println(a.getBrand());
		}
	}
}

class HDTV implements Comparable<HDTV>{
	
	private int size;
	private String brand;
 
	public HDTV(int size, String brand) {
		this.size = size;
		this.brand = brand;
	}
 
	public int getSize() {
		return size;
	}
 
	public void setSize(int size) {
		this.size = size;
	}
 
	public String getBrand() {
		return brand;
	}
 
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Override
	public int compareTo(HDTV tv) {
 
		if (this.getSize() > tv.getSize())
			return 1;
		else if (this.getSize() < tv.getSize())
			return -1;
		else
			return 0;
	}
	public String toString(){
		return this.brand + " [" + this.size +"]";
	}
}

class HDTVv2 {
	private int size;
	private String brand;
 
	public HDTVv2(int size, String brand) {
		this.size = size;
		this.brand = brand;
	}
 
	public int getSize() {
		return size;
	}
 
	public void setSize(int size) {
		this.size = size;
	}
 
	public String getBrand() {
		return brand;
	}
 
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String toString(){
		return this.brand + " [" + this.size +"]";
	}
}

class SizeComparator implements Comparator<HDTVv2> {
	@Override
	public int compare(HDTVv2 tv1, HDTVv2 tv2) {
		int tv1Size = tv1.getSize();
		int tv2Size = tv2.getSize();
 
		if (tv1Size > tv2Size) {
			return 1;
		} else if (tv1Size < tv2Size) {
			return -1;
		} else {
			return 0;
		}
	}
}