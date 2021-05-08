package com.saurabh.java.hfsj.ch09;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class GenerateSampleDataServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GenerateSampleDataServlet2() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(((String)request.getAttribute("exercise")).equalsIgnoreCase("ch9_1")){
				ArrayList<String> movies = new ArrayList<String>();
				movies.add("Blood Diamond");
				movies.add("Deja Vu");
				movies.add("Despicable Me 2");
				movies.add("Fast and Furious 5 Fast Five");
				movies.add("Iron Man 3");
				movies.add("Jack Reacher");
				movies.add("Leap Year");
				request.setAttribute("movies", movies);
				request.getRequestDispatcher("/jsps/usingjstlstandardactions.jsp").forward(request, response);
				
			}
			else if(((String)request.getAttribute("exercise")).equalsIgnoreCase("ch9_2")){
				StringBuffer htmlPageBuffer = new StringBuffer();
				StringBuffer bodyBuffer = new StringBuffer();
				bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "When buying a car, what is most important to you?"));
				bodyBuffer.append("<form action='jsps/usingjstlstandardactions2.jsp' method='get'>");
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Performance"));
				bodyBuffer.append("<input type=\"radio\" name=\"preference\" value=\"Performance\"/>");
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Safety"));
				bodyBuffer.append("<input type=\"radio\" name=\"preference\" value=\"Safety\" />");
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Maintenance"));
				bodyBuffer.append("<input type=\"radio\" name=\"preference\" value=\"Maintenance\" />");
				bodyBuffer.append("<br><br>");
				bodyBuffer.append("<input type='submit' value='Display'/>");
				bodyBuffer.append("</form>");
				
				htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 9 - JSTL choose tag", "resources/cssstyle.css" , bodyBuffer));
				htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());
				
				response.getWriter().println(htmlPageBuffer);
			}
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
