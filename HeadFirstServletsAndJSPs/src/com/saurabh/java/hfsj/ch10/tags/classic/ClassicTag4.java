package com.saurabh.java.hfsj.ch10.tags.classic;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.saurabh.java.hfsj.ch10.models.Movie;

public class ClassicTag4 extends TagSupport {

	private static final long serialVersionUID = 7467507289736180455L;
	
	private List<Movie> movies;
	private int movieCounter;
	
	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public int doStartTag() throws JspException{
		movieCounter = 0;
		pageContext.setAttribute("movie", movies.get(movieCounter));
		
		movieCounter++;
		return EVAL_BODY_INCLUDE;
	}
	
	public int doAfterBody() throws JspException{
		if(movieCounter < movies.size()){
			pageContext.setAttribute("movie", movies.get(movieCounter));
			movieCounter++;
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException{
		
		return EVAL_PAGE;
	}

}
