package com.saurabh.dada.iq.impl.collections;

public class SomeData implements Comparable<SomeData> {

	private Integer caseId=null;
	private String inWords=null;
	
	private SomeData(){
		//do nothing
	}
	
	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public SomeData(int caseId, String inWords){
		this();
		this.caseId = caseId;
		this.inWords = inWords;
	}

	public String getInWords() {
		return inWords;
	}

	public void setInWords(String inWords) {
		this.inWords = inWords;
	}

	@Override
	public int compareTo(SomeData o) {
		int result=0;
		if(caseId!=null && o.caseId!=null){
			result = this.caseId>o.caseId?1:-1;
		}
		return result;
	}

	public String toString(){
		return "[No: " + this.caseId + ", in Words: " + inWords+"]"; 
	}
}
