package com.saurabh.java.hfsj.ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class ViewRequestCookiesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewRequestCookiesServlets() {
        super();        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			PrintWriter out = response.getWriter();
			StringBuffer bodyBuffer = (StringBuffer) request.getAttribute("responseBodyBuffer");
			Cookie[] cookies = request.getCookies();
			bodyBuffer.append("<table border='1'>");
			for(Cookie cookie:cookies){
				bodyBuffer.append("<tr><td>"+cookie.getName()+"</td>");
				bodyBuffer.append("<td>"+cookie.getValue()+"</td></tr>");
			}
			bodyBuffer.append("</table>");
			out.println(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - Cookies", "resources/cssstyle.css" , bodyBuffer));
			out.println(GlobalHTMLTags.doEndHTMLBody());
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
		
	}

}
