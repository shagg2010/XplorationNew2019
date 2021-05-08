package com.saurabh.java.hfsj.ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class DisplayJSessionIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DisplayJSessionIdServlet() {
        super();
      }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer bodyBuffer = new StringBuffer();		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");		
		bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
		bodyBuffer.append("<br><br>");
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie: cookies){
			if(cookie.getName().equals("JSESSIONID")){
				sessionID = cookie.getValue();
			}
		}
		bodyBuffer.append(GlobalHTMLTags.doAppendHeading("3", "Servlet Cookie JSESSIONID: " + sessionID));
		bodyBuffer.append(GlobalHTMLTags.doAppendHeading("3", "JSESSIONID: " + request.getSession().getId()));
		out.println(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - URL Rewriting", "resources/cssstyle.css" , bodyBuffer));
		out.println(GlobalHTMLTags.doEndHTMLBody());
	}

}
