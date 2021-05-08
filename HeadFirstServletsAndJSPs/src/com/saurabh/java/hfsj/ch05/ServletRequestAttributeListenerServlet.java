package com.saurabh.java.hfsj.ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class ServletRequestAttributeListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletRequestAttributeListenerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("<h3>Check ServerLogs for this example</h3>");
		request.setAttribute("req_attribute", "value v1.0");
		request.setAttribute("req_attribute", "value v1.1");
		request.removeAttribute("req_attribute");
		out.println(GlobalHTMLTags.doStartHTMLBody("Chapter 5 - ServletRequestAttributeListener Example", bodyBuffer));
		out.println(GlobalHTMLTags.doEndHTMLBody());
	}

}
