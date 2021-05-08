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

public class ViewShoppingCartItemsServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewShoppingCartItemsServlet2() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			StringBuffer htmlPageBuffer = new StringBuffer();
			StringBuffer bodyBuffer = new StringBuffer();
			ArrayList<Books> shoppingCart = new ArrayList<Books>();
			shoppingCart = (ArrayList<Books>) request.getSession().getAttribute("shoppingCartToCheckout");			
			if(shoppingCart!=null){
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("3", "Thanks for buying! Your Shopping Cart: "));
				Iterator<Books> iterator = shoppingCart.iterator();
				int i= 1;
				while(iterator.hasNext()){
					Books book = iterator.next();
					bodyBuffer.append(GlobalHTMLTags.doAppendHeading("5", i + ". " + book));
				}
				htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - Http Sessions", "resources/cssstyle.css" , bodyBuffer));
				htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());
				
			}
			else{
				bodyBuffer.append(GlobalHTMLTags.doAppendHeading("4", "Oops... Session expired!"));
				htmlPageBuffer.append(GlobalHTMLTags.doStartHTMLBody("Chapter 6 - Http Sessions", "resources/cssstyle.css" , bodyBuffer));
				htmlPageBuffer.append(GlobalHTMLTags.doEndHTMLBody());
			}
			response.getWriter().println(htmlPageBuffer);
		}
		catch(Exception e){
			e.printStackTrace();
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
