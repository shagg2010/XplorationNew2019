package com.saurabh.java.hfsj.ch05;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextParamServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append("Context Parameters for this Web-app are as follows: <br>");
			bodyBuffer.append("produciton-mode: " + getServletContext().getInitParameter("produciton-mode")+"<br>");
			Enumeration<String> params = getServletContext().getInitParameterNames();
			while(params.hasMoreElements()){
				String param = params.nextElement();
				bodyBuffer.append(param+": " + getServletContext().getInitParameter(param)+"<br>");
			}
			response.getWriter().println(GlobalHTMLTags.doStartHTMLBody("Context Parameters in Web-App!", bodyBuffer));
			response.getWriter().println(GlobalHTMLTags.doEndHTMLBody());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
