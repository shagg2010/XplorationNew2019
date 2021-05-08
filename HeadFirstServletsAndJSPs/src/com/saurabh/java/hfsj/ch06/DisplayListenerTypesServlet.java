package com.saurabh.java.hfsj.ch06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class DisplayListenerTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayListenerTypesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] listenerTypes = {"ServletRequestListener","ServletRequesAttributetListener","ServletContextListener","ServletContextAttributeListener","HttpSessionListener","HttpSessionActivationListener","HttpSessionBindingListener","HttpSessionAttributeListener"};

		
		
		try{
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			StringBuffer tableBuffer = new StringBuffer();
			
			bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
			
			for(String listenerType: listenerTypes){
				tableBuffer.append(GlobalHTMLTags.doAppendHtmlTableData(1, listenerType));
			}
			System.out.println(tableBuffer);
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - Summary of all the Listeners", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());
			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
		
	}

}
