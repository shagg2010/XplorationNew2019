package com.saurabh.java.hfsj.ch10.tags.simple;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag7 extends SimpleTagSupport implements DynamicAttributes{
	
	private List<String> options;
	private String name;
	private Map<String, Object> tagAttrs = new HashMap<String, Object>();
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOptions(List<String> options) {
		this.options = options;
	}

	public void doTag() throws JspException, IOException{
		JspWriter out = getJspContext().getOut();
		out.print("<select name='" + this.name + "' ");
		for(String attrname: tagAttrs.keySet()){
			out.print(attrname+"='"+tagAttrs.get(attrname)+"' ");
		}
		out.print(">\n");
		
		for(String option: options){
			out.print("<option value"+"='"+option+"'>" + option + "</option>\n");
		}
		out.print("</select>");
	}

	@Override
	public void setDynamicAttribute(String uri, String name, Object value)
			throws JspException {
		tagAttrs.put(name, value);
		
	}

}
