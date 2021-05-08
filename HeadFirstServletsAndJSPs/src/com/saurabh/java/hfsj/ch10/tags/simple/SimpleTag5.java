package com.saurabh.java.hfsj.ch10.tags.simple;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.saurabh.java.hfsj.ch10.models.Movie;

public class SimpleTag5 extends SimpleTagSupport {
	
	private List<Movie> movies;
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public void doTag() throws JspException, IOException{
		for(Movie movie: movies){
			getJspContext().setAttribute("movie", movie);
			getJspBody().invoke(null);
		}
	}

}
