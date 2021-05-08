package com.saurabh.java.hfsj.ch13;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class CheckUserInRoleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public CheckUserInRoleServlet2() {
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
			if(request.isUserInRole("Admin")){
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "Current User is in Admin Role!"));
			}
			else if(request.isUserInRole("Member")){
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "Current User is in Member Role!"));
			}
			else if(request.isUserInRole("Guest")){
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "Current User is in Guest Role!"));
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
