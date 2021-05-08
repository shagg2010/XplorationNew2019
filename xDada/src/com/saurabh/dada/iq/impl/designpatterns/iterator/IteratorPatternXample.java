package com.saurabh.dada.iq.impl.designpatterns.iterator;

public class IteratorPatternXample {
	
	public static void main(String[] args) {
		NameRepository<String> namesRepository = new NameRepository<String>();

		for (Iterator<String> iter = namesRepository.getIterator(); iter.hasNext();) {
			String name = (String) iter.next();
			System.out.println("Name : " + name);
		}
	}

}
