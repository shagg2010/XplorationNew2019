package com.saurabh.java.hfsj.ch10.tags.simple;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag2 extends SimpleTagSupport {
	
	private String message="";
	private String color="blue";
		
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void doTag() throws JspException, IOException{
		getJspContext().getOut().write("My message is: <font color='" + getColor() + "'>" + getMessage() + "</font><br>");
		getJspBody().invoke(null);
	}

}
