package com.saurabh.java.hfsj.ch05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch05.models.AdminUser;

public class RemoveAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveAdminServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{			
			PrintWriter out = response.getWriter();
			StringBuffer bodyBuffer = new StringBuffer();
			ServletContext context = getServletContext();
			ArrayList<AdminUser> admins = (ArrayList<AdminUser>) context.getAttribute("admins");
			String param = request.getParameter("adminuser");
			int result = searchAdmin(admins, param);
			if (result != -1){
				bodyBuffer.append("Index of admin: " + result);
				admins.remove(result);
				context.setAttribute("admins", admins);
				bodyBuffer.append("<br><h3>Admin Removed: " + param+"</h3>");
			}
			else{
				if(param.equalsIgnoreCase("_all")){
					bodyBuffer.append("<br><h3>All Admins Removed! "+"</h3>");
					context.removeAttribute("admins");					
				}
				else{
					bodyBuffer.append("Admin not found!");
				}
			}
			
			out.println(GlobalHTMLTags.doStartHTMLBody("Admin Page", bodyBuffer));			
			out.println(GlobalHTMLTags.doEndHTMLBody());
		}
		catch(Exception e){
			getServletContext().log(e.getMessage());
		}
	}
	
	private int searchAdmin(ArrayList<AdminUser> admins, String Id){
		int indexOfAdminToBeRemoved = -1;
		try {
			Iterator<AdminUser> it = admins.iterator();
			while(it.hasNext()){
				AdminUser au = it.next();
				if(au.getId().equalsIgnoreCase(Id)){
					indexOfAdminToBeRemoved = admins.indexOf(au);
					return indexOfAdminToBeRemoved;
				}
					
			}
		} catch (Exception e) {
			getServletContext().log(e.getMessage());
		}
		return indexOfAdminToBeRemoved;
	}

}
