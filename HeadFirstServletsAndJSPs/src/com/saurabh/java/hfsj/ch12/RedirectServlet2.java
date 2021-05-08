package com.saurabh.java.hfsj.ch12;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public RedirectServlet2() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL = request.getParameter("url");
		System.out.println("--->URL: " + nextURL);
		request.getRequestDispatcher(nextURL).forward(request, response);
		//response.getWriter().print("URL: " + nextURL);
	}

}
