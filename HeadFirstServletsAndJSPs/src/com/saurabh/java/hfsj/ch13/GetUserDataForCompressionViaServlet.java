package com.saurabh.java.hfsj.ch13;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class GetUserDataForCompressionViaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetUserDataForCompressionViaServlet() {
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
			
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "Your details please...."));
			bodyBuffer.append("<form action='ch13_3/DisplayTextAreaServlet' method='post'>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Enter Text to compress:"));
			bodyBuffer.append("<textarea rows='30' cols='80' name='text'>");
			bodyBuffer.append("</textarea>");
			bodyBuffer.append("<br><br>");
			bodyBuffer.append("<input type='submit' value='Display'/>");
			bodyBuffer.append("</form>");
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 13 - Using Servlet Filters and Wrappers", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
