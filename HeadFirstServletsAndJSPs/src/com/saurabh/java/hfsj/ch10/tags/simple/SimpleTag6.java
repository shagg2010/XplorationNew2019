package com.saurabh.java.hfsj.ch10.tags.simple;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag6 extends SimpleTagSupport {

	public void doTag() throws JspException, IOException{
		JspWriter out = getJspContext().getOut();
		out.write("Message within the doTag <br>");
		out.print("About to throw SkipPageException... <br>");
		if(true){
			throw new SkipPageException("Just Like That...");
		}
	}

}
