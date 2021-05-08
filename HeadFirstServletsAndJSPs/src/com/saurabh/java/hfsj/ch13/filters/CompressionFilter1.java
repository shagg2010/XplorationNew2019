package com.saurabh.java.hfsj.ch13.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompressionFilter1 implements Filter {
    
	private ServletContext sc;
	private FilterConfig fc;
	
    public void init(FilterConfig fConfig) throws ServletException {
    	this.fc = fConfig;
    	this.sc = fc.getServletContext();
    	sc.log(">>> >>> " + fc.getFilterName() +" is initialzed!");
	}
    
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String requestURL = request.getRequestURL().toString();
		DummyHttpServletResponse dummyResponse = new DummyHttpServletResponse(response);
		
		sc.log("Requesting URL: "+requestURL+" Time:"+new Date());
		chain.doFilter(request, dummyResponse);
		
		PrintWriter out = response.getWriter();
		out.println(dummyResponse.toString());
		out.println("<b>Your are the "+1+" Visitor</b>");  
		out.close();
	}

	public void destroy() {
		sc.log(">>> >>> " + fc.getFilterName() +" is destroyed!");
	}	

}
