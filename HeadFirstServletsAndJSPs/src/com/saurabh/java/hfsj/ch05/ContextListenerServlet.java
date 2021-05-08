package com.saurabh.java.hfsj.ch05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch05.models.AdminUser;


public class ContextListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AdminUser adminUser=null;
       
    public ContextListenerServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(adminUser==null){
				adminUser = (AdminUser) getServletContext().getAttribute("adminUser");
				System.out.println("Fetch Successful: " + adminUser);
			}
			StringBuffer buffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append("Surprise... <br>"+adminUser.toString());
			buffer.append(GlobalHTMLTags.doStartHTMLBody("ServletContextListener Example - wohooo!", bodyBuffer));
			buffer.append(GlobalHTMLTags.doEndHTMLBody());
			response.getWriter().println(buffer.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
