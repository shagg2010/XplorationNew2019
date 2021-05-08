package com.saurabh.java.hfsj.ch06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch06.models.Books;

public class ViewShoppingCartItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewShoppingCartItemsServlet() {
        super();        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			ArrayList<Books> shoppingCartToCheckout = new ArrayList<Books>();
			
			String[] selectedISBNs = request.getParameterValues("shoppingCart");
			ArrayList<Books> books = (ArrayList<Books>) getServletContext().getAttribute("books");
			Iterator<Books> bookList = books.iterator();			
			
			int i=1;
			for(String isbn:selectedISBNs){
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", (i++) +". "+isbn));
				while(bookList.hasNext()){
					Books book = bookList.next();
					if(book.getIsbn().equalsIgnoreCase(isbn)){
						shoppingCartToCheckout.add(book);
						break;
					}
				}
			}
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(15);
			session.setAttribute("shoppingCartToCheckout", shoppingCartToCheckout);
			bodyBuffer.append("<a href=\""+ response.encodeURL("ViewShoppingCartItemsServlet2") +"\">");
			bodyBuffer.append("View Shopping Cart </a>");
			htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - Http Sessions", "resources/cssstyle.css" , bodyBuffer));
			htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());
			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
