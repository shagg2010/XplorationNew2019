package com.saurabh.java.hfsj.ch06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch06.listeners.SessionCounter;

public class SessionCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionCounterServlet() {
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
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "Total active sessions: " + SessionCounter.getActiveSessions()));
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - Active Session Tracking", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());
			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
		
	}

}
