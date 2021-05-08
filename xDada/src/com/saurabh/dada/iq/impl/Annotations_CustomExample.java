package com.saurabh.dada.iq.impl;

public class Annotations_CustomExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static @interface SimpleAnnotation {
	    String value();
	 
	    int[] types();
	}
	
	@SimpleAnnotation(value="an element", types=1)
	class Element {
	    @SimpleAnnotation(value = "an attribute", types = { 1, 2 })
	    public Element nextElement;
	}

}
