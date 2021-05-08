package com.saurabh.java.hfsj.ch06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch06.models.Books;

public class ShopBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ArrayList<Books> books = new ArrayList<Books>();  
	
    public ShopBooksServlet() {
        super();
        books.add(new Books("123", "Java1", "ABC1"));
        books.add(new Books("234", "Java2", "ABC2"));
        books.add(new Books("345", "Java3", "ABC3"));
        books.add(new Books("456", "Java4", "ABC4"));
        books.add(new Books("578", "Java5", "ABC5"));
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{			
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			bodyBuffer.append(GlobalHTMLTags.doAppendImage("resources/java-loading.jpg", "top", "50", "50", "Java Logo"));
			bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "Select Books to add in Cart: "));
			bodyBuffer.append("<form action=\"ViewShoppingCartItemsServlet\" method=\"post\">\n");
			getServletContext().setAttribute("books", books);
			Iterator<Books> iterator = books.iterator();
			while(iterator.hasNext()){
				Books book = iterator.next();
				bodyBuffer.append("<input type=\"checkbox\" name=\"shoppingCart\" value=\""+book.getIsbn()+"\" />" + book.getName() +" [Author: " + book.getAuthors() + "]<br>\n");
			}
			bodyBuffer.append("<input type=\"submit\" value=\"Add to Cart\" />\n");
			bodyBuffer.append("</form>\n");
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - Active Session Tracking", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());
			//System.out.println("htmlPageBuffer:\n" + htmlPageBuffer);
			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
