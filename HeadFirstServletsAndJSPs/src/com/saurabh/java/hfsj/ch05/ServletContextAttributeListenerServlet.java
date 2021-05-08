package com.saurabh.java.hfsj.ch05;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch05.models.AdminUser;

public class ServletContextAttributeListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletContextAttributeListenerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ArrayList<AdminUser> admins = new ArrayList<AdminUser>();
			ServletContext context = getServletContext();
			admins.add(new AdminUser("1","Saurabh", "rwx"));
			admins.add(new AdminUser("2","Priyanka", "rwx"));
			admins.add(new AdminUser("3","Ashish", "rw-"));
			admins.add(new AdminUser("4","Yasir", "rw-"));
			context.setAttribute("admins", admins);
			
		}
		catch(Exception e){
			getServletContext().log(e.getMessage());
		}
		getServletContext().getRequestDispatcher("/jsps/viewadmins.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
