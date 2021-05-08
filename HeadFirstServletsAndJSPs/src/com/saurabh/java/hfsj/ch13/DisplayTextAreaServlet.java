package com.saurabh.java.hfsj.ch13;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class DisplayTextAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public DisplayTextAreaServlet() {
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
			
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Your Text is as follows: "));
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("6", request.getParameter("text")));
			
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 13 - Using Servlet Filters and Wrappers", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
