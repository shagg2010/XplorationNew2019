package com.saurabh.java.hfsj.ch08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch08.models.Dog;
import com.saurabh.java.hfsj.ch08.models.Person2;

public class ProcessComplexPersonInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessComplexPersonInfoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String ageStr = request.getParameter("age");
			Byte age = new Byte(ageStr);
			Dog pet = new Dog(request.getParameter("dogname"), request.getParameter("breed"));
			Person2 person = new Person2(request.getParameter("name"), age , pet);
			request.setAttribute("person", person);
			request.getRequestDispatcher("jsps/viewpersondetails2.jsp").forward(request, response);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
