package com.saurabh.java.hfsj.ch12;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class GoAndPerformDatabaseActivitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String,String> hyperlinks = new HashMap<String, String>();
       
    public GoAndPerformDatabaseActivitiesServlet() {
        super();
        hyperlinks.put("/AddDB/AddToDatabaseServlet","http://localhost:8080/HeadFirstServletsAndJSPs/AddDB/AddToDatabaseServlet");
        hyperlinks.put("/UpdateDB/UpdateDatabaseServlet","http://localhost:8080/HeadFirstServletsAndJSPs/UpdateDB/UpdateDatabaseServlet");
        hyperlinks.put("/ViewDB/ViewDatabaseServlet","http://localhost:8080/HeadFirstServletsAndJSPs/ViewDB/ViewDatabaseServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
			//bodyBuffer.append("<form action='RedirectServlet' method='post'>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Please select the URL: "));
			//bodyBuffer.append("<input type='text' name='url'/>");
			Set<String> urltext = hyperlinks.keySet();
			for(String text: urltext){
				bodyBuffer.append(GlobalHTMLTags.doAppendHtmlHyperLink(hyperlinks.get(text), text));
				bodyBuffer.append("<br>");
			}
			bodyBuffer.append("<br><br>");
			//bodyBuffer.append("<input type='submit' value='Call Servlet'/>");
			//bodyBuffer.append("</form>");
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 11 - Servlet Mappings", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
