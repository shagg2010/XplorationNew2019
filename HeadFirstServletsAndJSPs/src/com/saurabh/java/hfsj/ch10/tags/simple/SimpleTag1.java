package com.saurabh.java.hfsj.ch10.tags.simple;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag1 extends SimpleTagSupport {
	
	private String message;
	private String color="red";
		
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
		getJspContext().getOut().write("Your message is: <font color='" + getColor() + "'>" + getMessage() + "</font>");
	}

}
