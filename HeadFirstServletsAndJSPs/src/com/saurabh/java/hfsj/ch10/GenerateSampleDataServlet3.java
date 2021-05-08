package com.saurabh.java.hfsj.ch10;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch10.models.Movie;

public class GenerateSampleDataServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerateSampleDataServlet3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(((String)request.getAttribute("exercise")).equalsIgnoreCase("ch10_2")){
				ArrayList<String> items = new ArrayList<String>();
				items.add("National Treasure");
				items.add("Leap Year");
				items.add("Serendipity");
				items.add("Journey 2");
				items.add("Babys Day Out");
				request.setAttribute("movieList", items);
				
				ArrayList<Movie> movies = new ArrayList<Movie>();
				movies.add(new Movie("National Treasure", "Action, Thriller, Suspense"));
				movies.add(new Movie("Leap Year", "Romantic, Comedy, Drama"));
				movies.add(new Movie("Serendipity", "Romantic, Comedy, Drama"));
				movies.add(new Movie("Babys Day Out", "Comedy, Action, Thriller, Suspense"));
				movies.add(new Movie("Journey 2", "Action, Thriller, Suspense, Comedy"));
				request.setAttribute("movies", movies);
				request.getRequestDispatcher("/jsps/usingsimpletags.jsp").forward(request, response);
			}
			
			if(((String)request.getAttribute("exercise")).equalsIgnoreCase("ch10_4")){
				
				ArrayList<Movie> movies = new ArrayList<Movie>();
				movies.add(new Movie("National Treasure", "Action, Thriller, Suspense"));
				movies.add(new Movie("Leap Year", "Romantic, Comedy, Drama"));
				movies.add(new Movie("Serendipity", "Romantic, Comedy, Drama"));
				movies.add(new Movie("Babys Day Out", "Comedy, Action, Thriller, Suspense"));
				movies.add(new Movie("Journey 2", "Action, Thriller, Suspense, Comedy"));
				request.setAttribute("movies", movies);
				request.getRequestDispatcher("/jsps/usingclassictags.jsp").forward(request, response);
			}
			
			if(((String)request.getAttribute("exercise")).equalsIgnoreCase("ch10_5")){
				
				ArrayList<String> items = new ArrayList<String>();
				items.add("National Treasure");
				items.add("Leap Year");
				items.add("Serendipity");
				items.add("Journey 2");
				items.add("Babys Day Out");
				request.setAttribute("movieList", items);
				
				request.getRequestDispatcher("/jsps/usingsimpletags2.jsp").forward(request, response);
				
			}
			
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
