package com.saurabh.java.hfsj.ch05.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saurabh.java.hfsj.ch05.models.AdminUser;

public class AdminUserServletContextListener implements ServletContextListener {
	
	private static Logger LOG = LoggerFactory.getLogger(AdminUserServletContextListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		context.removeAttribute("adminUser");
		LOG.info("\n>>>  >>> AdminUser removed from context...!");

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		context = event.getServletContext();
		String username = (String) context.getInitParameter("admin-username").toString();
		String privilegesFqn = (String) context.getInitParameter("admin-privileges").toString();
		AdminUser adminUser = new AdminUser("1",username,privilegesFqn);
		context.setAttribute("adminUser", adminUser);		
		AdminUser au = (AdminUser) context.getAttribute("adminUser");
		LOG.info("\n>>>  >>> AdminUser added in context...!");
		LOG.info("\n>>>  >>> " + au);		
	}

}
