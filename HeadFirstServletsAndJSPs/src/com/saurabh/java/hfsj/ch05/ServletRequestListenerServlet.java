package com.saurabh.java.hfsj.ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class ServletRequestListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletRequestListenerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		StringBuffer bodyBuffer = new StringBuffer();
		out.println(GlobalHTMLTags.doStartHTMLBody("Chapter 5 - ServletRequestListener Example", bodyBuffer));
		out.println(GlobalHTMLTags.doEndHTMLBody());
	}

}
