package com.saurabh.java.hfsj.ch10.tags.classic;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ClassicTag3 extends TagSupport {

	private static final long serialVersionUID = 7467507289736180455L;
	
	public int doStartTag() throws JspException{
		JspWriter out = pageContext.getOut();
		try{
			out.println("Classic Tag 3 Output [doStartTag]<br>");
		}
		catch(Exception e){
			e.printStackTrace();
			throw new JspException("IOException: " + e.toString());
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public int doAfterBody() throws JspException{
		JspWriter out = pageContext.getOut();
		try{
			out.println("Classic Tag 3 Output [doAfterBody]<br>");
		}
		catch(Exception e){
			e.printStackTrace();
			throw new JspException("IOException: " + e.toString());
		}
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException{
		JspWriter out = pageContext.getOut();
		try{
			out.println("Classic Tag 3 Output [doEndTag]<br>");
		}
		catch(Exception e){
			e.printStackTrace();
			throw new JspException("IOException: " + e.toString());
		}
		return EVAL_PAGE;
	}

}
