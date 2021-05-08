package com.saurabh.java.hfsj.ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;


public class VerifyOldSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VerifyOldSessions() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer bodyBuffer = new StringBuffer();		
		PrintWriter out = response.getWriter();		
		bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
		HttpSession session = request.getSession(false);
		if(session==null){
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("3", "Its a new Session therefore visit this page again."));
			session = request.getSession();
		}
		else{
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("3", "Its a old Session, nothing to worry now."));
		}
		out.println(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - Check Old Sessions", "resources/cssstyle.css" , bodyBuffer));
		out.println(GlobalHTMLTags.doEndHTMLBody());
	}

}
