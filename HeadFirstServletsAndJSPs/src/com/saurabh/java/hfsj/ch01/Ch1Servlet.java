package com.saurabh.java.hfsj.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ch1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ch1Servlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Date date = new Date();
		out.println(GlobalHTMLTags.doStartHTMLBody("Chapter 1"));
		out.println("Todays date is: " + date.toString());
		out.println(GlobalHTMLTags.doEndHTMLBody());
	}
	
}
