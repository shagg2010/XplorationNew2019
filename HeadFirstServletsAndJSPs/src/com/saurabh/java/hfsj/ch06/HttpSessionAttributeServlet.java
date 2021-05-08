package com.saurabh.java.hfsj.ch06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class HttpSessionAttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HttpSessionAttributeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.getSession().setAttribute("SessionAttribute1", "SessionAttribute1Value_v1.1");
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("6", "Check Server logs..."));
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - Session Attribute Listener", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());
			response.getWriter().println(htmlPageBuffer);
			request.getSession().removeAttribute("SessionAttribute1");
			request.getSession().removeAttribute("SessionAttribute2");
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
