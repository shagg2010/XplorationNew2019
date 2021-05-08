package com.saurabh.java.hfsj.ch09;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch09.models.Dog;
import com.saurabh.java.hfsj.ch09.models.Person;

public class DataPreparationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DataPreparationServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String dogname = request.getParameter("dogname");
			String breed = request.getParameter("breed");

			Person person = new Person(name,new Byte(age), new Dog(dogname, breed));
			request.setAttribute("person", person);
			request.getRequestDispatcher("jsps/viewpersondetails3.jsp").forward(request, response);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
