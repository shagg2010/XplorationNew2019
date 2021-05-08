package com.saurabh.java.hfsj.ch13;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class CompressResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompressResponseServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", ""));
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 13 - Using Servlet Wrappers", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			System.out.println(">>> >>> Response Class Name: " + response.getClass().getCanonicalName());
			response.getWriter().println(htmlPageBuffer);
			//response.getWriter().write(1);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
