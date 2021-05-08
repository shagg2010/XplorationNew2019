package com.saurabh.dada.iq.impl.iq.symantec;

import java.io.Serializable;

public interface CitiInterface extends Serializable{

	void myMethod();
	abstract void myMethod2();
	public void myMethod3();
	//private void myMethod3();   Not allowed
	//public static void myMethod3();   Not allowed
}
