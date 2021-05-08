package com.saurabh.java.hfsj.ch04;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class SendRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendRedirectServlet() {
        super();
    }
    
    public void init(ServletConfig config){
    	try{
    		super.init(config);
    		System.out.println("Contact me at: " + getServletConfig().getInitParameter("myemail"));
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gotoGoogle = (String)request.getParameter("gotoGoogle").toString();
		String query = (String) request.getParameter("query").toString();
		if(Boolean.valueOf(gotoGoogle)){
			response.sendRedirect("http://www.google.com/#q="+query);
		}
		else{
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append(GlobalHTMLTags.doStartHTMLBody("Not redirected to Google!"));
			bodyBuffer.append("Contact me at: " + getServletConfig().getInitParameter("myemail"));
			bodyBuffer.append(GlobalHTMLTags.doEndHTMLBody());
			response.getWriter().print(bodyBuffer.toString());
		}
	}

}
