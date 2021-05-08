package com.saurabh.java.hfsj.ch08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch08.models.Person3;

public class ProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessingServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(request.getParameter("exercise").equalsIgnoreCase("ch8_3")){
				System.out.println("---> exercise: ch8_3");
				String name = request.getParameter("name");
				String age = request.getParameter("age");
				String hobbies = request.getParameter("hobbies");
				
				String[] hobbiesList = hobbies.split(",");
				Person3 person = new Person3(name,new Byte(age), hobbiesList);
				request.setAttribute("person", person);
				request.getRequestDispatcher("jsps/viewpersondetails3.jsp").forward(request, response);
			}
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
