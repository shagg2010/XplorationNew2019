package com.saurabh.java.hfsj.ch10.tags.simple;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag4 extends SimpleTagSupport {
	
	private List<String> items;
	
	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public void doTag() throws JspException, IOException{
		for(String item: items){
			getJspContext().setAttribute("item", item);
			getJspBody().invoke(null);
			getParent();
		}
	}

}
