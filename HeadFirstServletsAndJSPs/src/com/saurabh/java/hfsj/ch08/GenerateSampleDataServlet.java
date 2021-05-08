package com.saurabh.java.hfsj.ch08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;

public class GenerateSampleDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerateSampleDataServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(((String)request.getAttribute("exercise")).equalsIgnoreCase("ch8_4")){
				
				HashMap<String, String> musicMap = new HashMap<String, String>();
				musicMap.put("Ambient", "Zero 7");
				musicMap.put("Surf", "Tahiti 80");
				musicMap.put("DJ", "BT");
				musicMap.put("Indie", "Travis");
				
				String[] musicType = {"Ambient","Surf","DJ","Indie"};
				
				ArrayList<String> nums = new ArrayList<String>();
				nums.add("1");
				nums.add("2");
				nums.add("3");
				
				String[] favMusic = {"Zero 7","Tahiti 80","BT","Frou Frou"};
				
				request.setAttribute("musicMap", musicMap);
				request.setAttribute("Genre", "Ambient");
				request.setAttribute("musicType", musicType);
				request.setAttribute("favMusic", favMusic);
				request.setAttribute("numbers", nums);
				
				
				request.getRequestDispatcher("/jsps/viewdatausingel.jsp").forward(request, response);
			}
			else if(((String)request.getAttribute("exercise")).equalsIgnoreCase("ch8_6")){
				
				//http://www.informit.com/articles/article.aspx?p=30946&seqNum=7
				HashMap<String, String> musicMap = new HashMap<String, String>();
				musicMap.put("Ambient", "Zero 7");
				musicMap.put("Surf", "Tahiti 80");
				musicMap.put("DJ", "BT");
				musicMap.put("Indie", "Travis");
				
				String[] musicType = {"Ambient","Surf","DJ","Indie"};
				
				ArrayList<String> nums = new ArrayList<String>();
				nums.add("1");
				nums.add("2");
				nums.add("3");
				
				String[] favMusic = {"Zero 7","Tahiti 80","BT","Frou Frou"};
				
				request.setAttribute("musicMap", musicMap);
				request.setAttribute("Genre", "Ambient");
				request.setAttribute("musicType", musicType);
				request.setAttribute("favMusic", favMusic);
				request.setAttribute("numbers", nums);
				
				 String[] cookieNames = {"acme.userName", "acme.password","acme.lastAccessDate"};
				 String[] cookieValues = {"ronw", "iuo82wer", "2002-03-08"};

				 // Create cookies and add them to the HTTP response
				 for(int i=0; i < cookieNames.length; ++i) {
					 Cookie cookie = new Cookie(cookieNames[i], cookieValues[i]); 
					 response.addCookie(cookie);
				 }
				
				request.getRequestDispatcher("/jsps/viewimplicitobjectsusingel.jsp").forward(request, response);
			}
			else if(((String)request.getAttribute("exercise")).equalsIgnoreCase("ch8_7")){
				Cookie cookie =  new Cookie("session-id","jsessionid");
				response.addCookie(cookie);
				request.getRequestDispatcher("/jsps/viewimplicitobjectsusingel2.jsp").forward(request, response);
			}
			else if(((String)request.getAttribute("exercise")).equalsIgnoreCase("ch8_9")){
				
				List<String> list = new ArrayList<String>();
				list.add("true");
				list.add("false");
				list.add("2");
				list.add("10");
				
				request.setAttribute("num", "2");
				request.setAttribute("integer", new Integer(3));
				request.setAttribute("list", list);
				request.getRequestDispatcher("/jsps/usingeloperators.jsp").forward(request, response);
			}
		}
		catch(Exception e){
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}

}
