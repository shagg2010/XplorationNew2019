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

public class GenerateLinksToCheckUserInRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String,String> hyperlinks = new HashMap<String, String>();
       
    public GenerateLinksToCheckUserInRoleServlet() {
        super();
        hyperlinks.put("CheckUserInRoleServlet","http://localhost:8080/HeadFirstServletsAndJSPs/ch12/CheckUserInRoleServlet");
        hyperlinks.put("CheckUserInRoleServlet - HTTPS","https://localhost:8443/HeadFirstServletsAndJSPs/ch12/CheckUserInRoleServlet");
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			//String authHeader = request.getHeader("Authorization");
			//String encodedValue = authHeader.split(" ")[1];
			//String decodedValue = Base64.base64Decode(encodedValue);
			
			
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", "Please click the URL: "));
			Set<String> urltext = hyperlinks.keySet();
			for(String text: urltext){
				bodyBuffer.append(GlobalHTMLTags.doAppendHtmlHyperLink(hyperlinks.get(text), text));
				bodyBuffer.append("<br>");
			}
			bodyBuffer.append("<br><br>");
			
			//bodyBuffer.append("Base64-encoded Authorization Value: <em>" + encodedValue);
			//bodyBuffer.append("</em><br/>Base64-decoded Authorization Value: <em>" + decodedValue);
			
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 12 - Programmatic Security", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());

			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
