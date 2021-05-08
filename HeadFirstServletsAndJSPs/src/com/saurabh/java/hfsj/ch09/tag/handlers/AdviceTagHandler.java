package com.saurabh.java.hfsj.ch09.tag.handlers;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdviceTagHandler extends SimpleTagSupport {
	
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public void doTag() throws JspException, IOException{
		JspWriter out = getJspContext().getOut();
		out.write("Hello: " + getUser() + "<br>");
		out.write("<b>Advice of the Day: " + getAdvice() + "</b><br>");
		
	}
	
	private String getAdvice(){
		String[] adviceStrings = {"That color's not working for you.", "You should call in sick.","You might want to rethink that haircut."};
		int random = (int) (Math.random() * adviceStrings.length);
		return adviceStrings[random];
	}
}
