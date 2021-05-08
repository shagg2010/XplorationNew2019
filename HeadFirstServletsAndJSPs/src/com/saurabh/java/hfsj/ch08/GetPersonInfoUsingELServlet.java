package com.saurabh.java.hfsj.ch08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class GetPersonInfoUsingELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPersonInfoUsingELServlet() {
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
			bodyBuffer.append("<form action='jsps/viewpersondetails.jsp' method='get'>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Name: "));
			bodyBuffer.append("<input type='text' name='name'/>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Age: "));
			bodyBuffer.append("<input type='text' name='age'/>");
			bodyBuffer.append("<br><br>");
			bodyBuffer.append("<input type='submit' value='Display'/>");
			bodyBuffer.append("</form>");
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 8 - Introduction to EL", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
			
			//Person person = new Person("Saurabh", (byte) 26);
			//request.setAttribute("person", person);
			
			//if calling viewpersonusingel.jsp from request.getRequestDispatcher - always use / at the beginning because it works on relative path
			//request.getRequestDispatcher("/jsps/viewpersonusingel.jsp").forward(request, response);
			
			//if calling viewpersonusingel.jsp from context.getRequestDispatcher - always use / at the beginning because I DO NOT KNOW
			//getServletContext().getRequestDispatcher("/jsps/viewpersonusingel.jsp").forward(request, response);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
