package com.saurabh.java.hfsj.ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class InitParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitParameterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String hostname = getServletConfig().getInitParameter("hostname");
			String port = getServletConfig().getInitParameter("port");
			PrintWriter out = response.getWriter();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append("<h2>Server host and port details: </h3><br>");
			bodyBuffer.append("Hostname: " + hostname + "<br>");
			bodyBuffer.append("Port: " + port);
			out.print(GlobalHTMLTags.doStartHTMLBody("Servlet Init Parameters", bodyBuffer));
			out.print(GlobalHTMLTags.doEndHTMLBody());
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
