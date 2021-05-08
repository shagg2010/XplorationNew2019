package com.saurabh.dada.iq.impl.collections;

import java.util.Comparator;

public class SomeData2 {

	private Integer caseId=null;
	private String inWords=null;
	
	private SomeData2(){
		//do nothing
	}
	
	public SomeData2(int caseId, String inWords){
		this();
		this.caseId = caseId;
		this.inWords = inWords;
	}
	
	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getInWords() {
		return inWords;
	}

	public void setInWords(String inWords) {
		this.inWords = inWords;
	}

	public static final Comparator<SomeData2> CASE_ID_COMPARATOR = new Comparator<SomeData2>() {
		public int compare(SomeData2 o1,SomeData2 o2){
			return o1.getCaseId() - o2.getCaseId();
		}
	};
	
/*	public int compareTo(SomeData2 o) {
		int result=0;
		if(caseId!=null && o.caseId!=null){
			result = this.caseId>o.caseId?1:-1;
		}
		return result;
	}*/

	public String toString(){
		return "[II No: " + this.caseId + ", in Words: " + inWords+"]"; 
	}
}
