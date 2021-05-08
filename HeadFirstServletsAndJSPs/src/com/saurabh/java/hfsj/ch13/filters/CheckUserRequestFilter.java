package com.saurabh.java.hfsj.ch13.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CheckUserRequestFilter implements Filter {
	
	private FilterConfig filterConfig;

    public CheckUserRequestFilter() {
    	System.out.println(">>> >>> Filter class loaded!");
    }

    public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest req = (HttpServletRequest) request;
    	String user = req.getRemoteUser();
    	String method = req.getMethod();
    	System.out.println(">>> >>> Filter msg [HTTP " + method + " method invoked by: " + user + "]");
    	filterConfig.getServletContext().log(">>> >>> Filter msg [HTTP " + method + " method invoked by: " + user + "]");
		chain.doFilter(request, response);
	}
    
	public void destroy() {
		System.out.println(">>> >>> Filter destroyed!");
	}

	

	

}
