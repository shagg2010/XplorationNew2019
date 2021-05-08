package com.saurabh.dada.iq.impl.designpatterns.compositeentity;

public class CompositeEntityPatternXample {
	
	public static void main(String[] args) {

		Client client = new Client();
		client.setData("Test", "Data");
		client.printData();
		client.setData("Second Test", "Data1");
		client.printData();
	}

}
