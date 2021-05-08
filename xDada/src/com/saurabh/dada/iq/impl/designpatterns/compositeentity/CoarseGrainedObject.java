package com.saurabh.dada.iq.impl.designpatterns.compositeentity;

public class CoarseGrainedObject {
	
	private DependentObject1 do1 = null;
	private DependentObject2 do2 = null;
	
	public CoarseGrainedObject() {
		do1 = new DependentObject1();
		do2 = new DependentObject2();
	}

	public void setData(String data1, String data2) {
		do1.setData(data1);
		do2.setData(data2);
	}

	public String[] getData() {
		return new String[] { do1.getData(), do2.getData() };
	}
}