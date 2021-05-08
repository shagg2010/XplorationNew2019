package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {
	
	public final List<Integer> list;

	public ImmutableClass(final List<Integer> list1){
		this.list = list1;
	}
	
	
	public List<Integer> getList() {
		return list;
	}


	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		
		ImmutableClass ic = new ImmutableClass(Collections.unmodifiableList(l));
		ic.getList().set(0, 10);
		System.out.println(ic.getList());
		ic.list.add(8);
		System.out.println(ic.list);
		

	}

}
