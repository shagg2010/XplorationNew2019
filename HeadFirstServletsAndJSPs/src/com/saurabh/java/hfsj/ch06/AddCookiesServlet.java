package com.saurabh.java.hfsj.ch06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class AddCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer bodyBuffer = new StringBuffer();		
		response.setContentType("text/html");		
		bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
		bodyBuffer.append("<br><br>");
		bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "JSESSIONID from AddCookiesServlet: " + request.getSession().getId()));
		bodyBuffer.append("<br>");
		Cookie cookie = new Cookie("UserEmail", "shagg2006@gmail.com");
		cookie.setComment("Storing the name of the user as an ID");
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
		request.setAttribute("responseBodyBuffer", bodyBuffer);
		request.getRequestDispatcher("/ch06/ViewRequestCookiesServlets").forward(request, response);
		
	}


}
