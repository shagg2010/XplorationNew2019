package com.saurabh.java.hfsj.ch11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class GenerateSampleURLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String> options = new ArrayList<String>();
       
    public GenerateSampleURLServlet() {
        super();
        options.add("/blue.do");
        options.add("/fooStuff/bar");
        options.add("/fooStuff/bar/blue.do");
        options.add("/fooStuff/blue.do");
        options.add("/fred/blue.do");
        options.add("/fooStuff");
        options.add("/fooStuff/bar/foo.fo");
        options.add("/fred/blue.fo");
        options.add("/fooStuff/bar/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
			bodyBuffer.append("<form action='RedirectServlet2' method='post'>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Please select the URL: "));
			//bodyBuffer.append("<input type='text' name='url'/>");
			bodyBuffer.append(GlobalHTMLTags.doAppendHtmlSelect("url", options));
			bodyBuffer.append("<br><br>");
			bodyBuffer.append("<input type='submit' value='Call Servlet'/>");
			bodyBuffer.append("</form>");
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 11 - Servlet Mappings", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
