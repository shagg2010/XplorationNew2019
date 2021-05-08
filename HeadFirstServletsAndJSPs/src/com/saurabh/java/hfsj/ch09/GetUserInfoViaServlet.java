package com.saurabh.java.hfsj.ch09;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class GetUserInfoViaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetUserInfoViaServlet() {
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
			bodyBuffer.append("<form action='jsps/usingsetpropertytaginjstl.jsp' method='get'>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Name: "));
			bodyBuffer.append("<input type='text' name='name'/>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Age: "));
			bodyBuffer.append("<input type='text' name='age'/>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Dog's Name: "));
			bodyBuffer.append("<input type='text' name='dogname'/>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Dog's Breed: "));
			bodyBuffer.append("<input type='text' name='breed'/>");
			bodyBuffer.append("<br><br>");
			bodyBuffer.append("<input type='submit' value='Display'/>");
			bodyBuffer.append("</form>");
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 9 - JSTL Set Property Tag", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}


}
