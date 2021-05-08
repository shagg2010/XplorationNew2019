package com.saurabh.java.hfsj.ch13;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class CheckUsageOfSimpleFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String,String> hyperlinks = new HashMap<String, String>();
       
    public CheckUsageOfSimpleFilterServlet() {
        super();
        hyperlinks.put("CheckUserInRoleServlet","http://localhost:8080/HeadFirstServletsAndJSPs/ch13/CheckUserInRoleServlet2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
			
			Set<String> urltext = hyperlinks.keySet();
			for(String text: urltext){
				bodyBuffer.append(GlobalHTMLTags.doAppendHtmlHyperLink(hyperlinks.get(text), text));
				bodyBuffer.append("<br>");
			}
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 13 - Using Filters", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
