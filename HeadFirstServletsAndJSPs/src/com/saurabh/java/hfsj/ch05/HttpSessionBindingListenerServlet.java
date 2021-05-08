package com.saurabh.java.hfsj.ch05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch05.listeners.AdminUserHttpSessionBindingListernerClass;


public class HttpSessionBindingListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AdminUserHttpSessionBindingListernerClass adminUserListnerAttribute=null;
       
    public HttpSessionBindingListenerServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(adminUserListnerAttribute==null){
				adminUserListnerAttribute = (AdminUserHttpSessionBindingListernerClass) request.getSession().getAttribute("adminUserListnerAttribute");
				System.out.println("Fetch Successful "+ "[Session ID: " + request.getSession().getId() + "]-" + adminUserListnerAttribute);
				request.getSession().removeAttribute("adminUserListnerAttribute");
			}
			StringBuffer buffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append("Surprise... <br>"+adminUserListnerAttribute.toString());
			buffer.append(GlobalHTMLTags.doStartHTMLBody("HttpSessionBindingListener Example - Lovin' it!!", bodyBuffer));
			buffer.append(GlobalHTMLTags.doEndHTMLBody());
			response.getWriter().println(buffer.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
