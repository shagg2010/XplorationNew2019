package com.saurabh.java.hfsj.ch13.filters;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class DummyHttpServletResponse extends HttpServletResponseWrapper {

	private CharArrayWriter buffer;
	
	public DummyHttpServletResponse(HttpServletResponse response) {
		super(response);
		buffer = new CharArrayWriter();
	}
	
	public String toString(){
		return buffer.toString();
	}

	public PrintWriter getWriter(){
		return new PrintWriter(buffer);
	}
}
