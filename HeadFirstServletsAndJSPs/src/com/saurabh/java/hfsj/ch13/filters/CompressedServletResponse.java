package com.saurabh.java.hfsj.ch13.filters;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CompressedServletResponse extends HttpServletResponseWrapper {
	
	private GZIPServletOutputStream servletGzipOS = null;
	private PrintWriter pw = null;
	private Object streamUsed = null;

	public CompressedServletResponse(HttpServletResponse response) {
		super(response);
	}
	
	public GZIPOutputStream getGzipOutputStream(){
		return this.servletGzipOS.internalGzipOS;
	}
	
	public void setContentLenght(int len){ 
		
	}
	
	public ServletOutputStream getOutputStream() throws IOException{
		if((streamUsed!=null) && (streamUsed != pw)){
			throw new IllegalStateException();
		}
		if(servletGzipOS == null){
			servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
			streamUsed = servletGzipOS;
		}
		return servletGzipOS;
	}
	
	public PrintWriter getWriter() throws IOException{
		if((streamUsed!=null) && (streamUsed != pw)){
			throw new IllegalStateException();
		}
		if(pw==null){
			servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
			OutputStreamWriter out = new OutputStreamWriter(servletGzipOS, getResponse().getCharacterEncoding());
			pw = new PrintWriter(out);
			streamUsed = pw;
		}
		return pw;
	}

}
