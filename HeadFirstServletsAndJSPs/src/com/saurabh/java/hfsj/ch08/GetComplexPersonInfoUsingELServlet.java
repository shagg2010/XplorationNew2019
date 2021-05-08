package com.saurabh.java.hfsj.ch08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

/**
 * Servlet implementation class GetComplexPersonInfoUsingELServlet
 */
public class GetComplexPersonInfoUsingELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetComplexPersonInfoUsingELServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			
			bodyBuffer.append("<form action='ProcessComplexPersonInfoServlet' method='post'>");
			bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
			
			bodyBuffer.append("<table border='0'>");
			bodyBuffer.append("<tr>");
			bodyBuffer.append("<td colspan='2'>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("3", "Your details please...."));
			bodyBuffer.append("</td>");
			bodyBuffer.append("</tr>");
			bodyBuffer.append("<tr>");
			bodyBuffer.append("<td>");			
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Name: "));
			bodyBuffer.append("<input type='text' name='name'/>");
			bodyBuffer.append("</td>");
			bodyBuffer.append("<td>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Age: "));
			bodyBuffer.append("<input type='text' name='age'/>");
			bodyBuffer.append("</td>");
			bodyBuffer.append("</tr>");
			bodyBuffer.append("<tr>");
			
			bodyBuffer.append("<tr>");
			bodyBuffer.append("<td colspan='2'>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "Your Dog details please...."));
			bodyBuffer.append("</td>");
			bodyBuffer.append("</tr>");
			bodyBuffer.append("<tr>");
			bodyBuffer.append("<td>");			
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Dogs' Name: "));
			bodyBuffer.append("<input type='text' name='dogname'/>");
			bodyBuffer.append("</td>");
			bodyBuffer.append("<td>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Dogs' Breed: "));
			bodyBuffer.append("<input type='text' name='breed'/>");
			bodyBuffer.append("</td>");
			bodyBuffer.append("</tr>");
			bodyBuffer.append("<tr>");
			
			bodyBuffer.append("<td colspan='2'>");
			bodyBuffer.append("<br><br>");
			bodyBuffer.append("<input type='submit' value='Display'/>");
			bodyBuffer.append("</td>");
			bodyBuffer.append("</tr>");
			bodyBuffer.append("</table>");
			
			bodyBuffer.append("</form>");
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 8 - More on EL", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
