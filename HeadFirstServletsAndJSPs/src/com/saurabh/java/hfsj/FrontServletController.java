package com.saurabh.java.hfsj;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saurabh.java.hfsj.ch01.GlobalHTMLTags;
import com.saurabh.java.hfsj.ch05.listeners.AdminUserHttpSessionBindingListernerClass;

public class FrontServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Properties props = null;
	private static Logger LOG = LoggerFactory.getLogger(FrontServletController.class);
      
	//http://localhost:8080/HeadFirstServletsAndJSPs/FrontServletController?exercise=ch8_1
	//http://localhost:8080/HeadFirstServletsAndJSPs/
    public FrontServletController() {
        super();
        props = new Properties();        
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	try{
    		props.load(getServletContext().getResourceAsStream("/resources/servlet-mappings.properties"));   		
    		getServletContext().log("Servlet Mapping with index page: " + props);
    		LOG.info("\n>>>  >>> Servlet Mappings: "+props);	
        }
        catch(Exception e){
        	e.printStackTrace();
        }    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String exercise = null;
			exercise = (String) request.getParameter("exercise");
			try{
				StringBuffer servletURL = new StringBuffer(servletRedirectURLMappings().get(exercise));	
				LOG.info("\n>>>  >>> Exercise to be executed: " + exercise + " and Mapping Servlet URL is: " + servletURL);
				doChapterSpecificTasks(request, response, exercise, servletURL);
				request.getRequestDispatcher(servletURL.toString()).forward(request, response);				
			}
			catch(Exception e){
				e.printStackTrace();
				response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));	
			}

		}
		catch(Exception e){
			e.printStackTrace();
			response.getWriter().println(GlobalHTMLTags.displayErrorPage(e));
		}
	}
	
	private void doChapterSpecificTasks(HttpServletRequest request, HttpServletResponse response, String exercise, StringBuffer servletURL){
		try{
			if(exercise.equals("ch5_4")){
				String username = (String) getServletContext().getInitParameter("admin-username").toString();
				String privilegesFqn = (String) getServletContext().getInitParameter("admin-privileges").toString();
				AdminUserHttpSessionBindingListernerClass adminUserListnerAttribute = new AdminUserHttpSessionBindingListernerClass(username,privilegesFqn);
				request.getSession().setAttribute("adminUserListnerAttribute", adminUserListnerAttribute);
				LOG.info("\n>>>  >>> AdminUserHttpSessionBindingListernerClass added in session...!");
				request.getSession().setMaxInactiveInterval(10);					
			}
			if(exercise.equals("ch5_6")){
				request.setAttribute("RequestAttribute1", "RequestAttribute1Value");
				request.setAttribute("RequestAttribute2", "RequestAttribute2Value");
				servletURL.append("?RequestP1=p1&RequestP2=p2");
			}
			if(exercise.equals("ch6_5")){
				request.getSession().setMaxInactiveInterval(15);
				System.out.println("\nSession modified [" + request.getSession().getId() + "] @ " + new Date(request.getSession().getCreationTime()) + " with validity of: " + request.getSession().getMaxInactiveInterval() + " seconds.");
			}
			if(exercise.equals("ch6_6")){
				request.getSession().setAttribute("SessionAttribute1", "SessionAttribute1Value_v1.0");
				request.getSession().setAttribute("SessionAttribute2", "SessionAttribute2Value_v1.0");
			}
			if(exercise.equals("ch6_7")){
				request.getSession().invalidate();
			}
			if(exercise.equals("ch8_4")){
				request.setAttribute("exercise", "ch8_4");
			}
			if(exercise.equals("ch8_6")){
				request.setAttribute("exercise", "ch8_6");
			}
			if(exercise.equals("ch8_7")){
				request.setAttribute("exercise", "ch8_7");
			}
			if(exercise.equals("ch8_9")){
				request.setAttribute("exercise", "ch8_9");
			}
			if(exercise.equals("ch9_1")){
				request.setAttribute("exercise", "ch9_1");
			}
			if(exercise.equals("ch9_2")){
				request.setAttribute("exercise", "ch9_2");
			}
			if(exercise.equals("ch10_2")){
				request.setAttribute("exercise", "ch10_2");
			}
			if(exercise.equals("ch10_4")){
				request.setAttribute("exercise", "ch10_4");
			}
			if(exercise.equals("ch10_5")){
				request.setAttribute("exercise", "ch10_5");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Map<String,String> servletRedirectURLMappings() throws IOException{
		if(props==null){
			props.load(getServletContext().getResourceAsStream("/resources/servlet-mappings.properties"));
		}  
		Map<String,String> servletRedirectURLMap = new HashMap<String, String>();
		for (String key : props.stringPropertyNames()) {
		    String value = props.getProperty(key);
		    servletRedirectURLMap.put(key, value);
		}
		getServletContext().log("Servlet Mapping with index page: " + servletRedirectURLMap);
		return servletRedirectURLMap;
	}

}
