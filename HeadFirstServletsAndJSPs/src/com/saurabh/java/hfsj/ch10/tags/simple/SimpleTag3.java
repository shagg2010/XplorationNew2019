package com.saurabh.java.hfsj.ch10.tags.simple;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag3 extends SimpleTagSupport {

	public void doTag() throws JspException, IOException{
		getJspContext().setAttribute("message", "Wear Sunscreen always in the sun.");
		getJspBody().invoke(null);
	}

}
