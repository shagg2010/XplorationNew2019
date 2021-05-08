<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.saurabh.java.hfsj.ch01.GlobalHTMLTags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% out.println(GlobalHTMLTags.doAppendCSSFile("resources/cssstyle.css")); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 7 - Different Scopes in JSPs</title>
</head>
<body>
<%! int app_var=4;
int session_var=3;
int page_var=1;
int request_var=2;

%>
Check Server logs...
<% pageContext.getServletContext().setAttribute("var", app_var);
	application.setAttribute("var", app_var);
	
	session.setAttribute("var", session_var);
	pageContext.getSession().setAttribute("var", session_var);
	
	request.setAttribute("var", request_var);
	pageContext.getRequest().setAttribute("var", request_var);
	
	pageContext.setAttribute("var", page_var);
	
	%>
	<br><br>
	<h4>JSP Scopes for storing the attributes</h4>
	<br>
	Application Attribute: <%=pageContext.getAttribute("var", PageContext.APPLICATION_SCOPE) %> <br>
	Page Attribute: <%=pageContext.getAttribute("var", PageContext.PAGE_SCOPE) %> <br>
	Request Attribute: <%=pageContext.getAttribute("var", PageContext.REQUEST_SCOPE) %> <br>
	Session Attribute: <%=pageContext.getAttribute("var", PageContext.SESSION_SCOPE) %> <br>
	
	<%
	
	pageContext.removeAttribute("var");
	
	request.removeAttribute("var");
	application.removeAttribute("var");
	
%>
</body>
</html>