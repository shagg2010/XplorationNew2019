package com.saurabh.java.hfsj.ch10.tags.classic;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class ClassicTag5 extends BodyTagSupport {

	private static final long serialVersionUID = 7467507289736180455L;

	public int doStartTag() throws JspException{
		return EVAL_BODY_BUFFERED;
	}
	
	public void doInitBody() throws JspException {
		String body = getBodyContent().getString();
		System.out.println("---> Body of Classic Tag 5: " + body);
	}
	
	public int doAfterBody() throws JspException{
		try{
			//getBodyContent().write("Hello <c:out value='World!'/>");
			String body = getBodyContent().getString();
			JspWriter out = getBodyContent().getEnclosingWriter();
			if(body!=null){
				out.print(body.toUpperCase());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new JspException("IOException: " + e.toString());
		}
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException{
		
		return EVAL_PAGE;
	}

}
