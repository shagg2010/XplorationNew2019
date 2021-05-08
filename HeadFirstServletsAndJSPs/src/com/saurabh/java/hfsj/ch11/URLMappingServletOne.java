package com.saurabh.java.hfsj.ch11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class URLMappingServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public URLMappingServletOne() {
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
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "URLMappingServletOne is selected"));
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 11 - Servlet Mappings", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
