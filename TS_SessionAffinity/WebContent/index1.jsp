<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Load Balancing using Tomcat, HTTPD and Mod_jk</title>
</head>
<body>

	Hi from Tomcat base instance! 
	<br>
	Server port: <%=request.getServerPort()%>
	<% 
	String serverInfo = config.getServletContext().getServerInfo();
	System.out.println("Server Info: " + serverInfo);
	
	System.out.println("Local name: " + request.getLocalName() + "\t Server name: " + request.getServerName());
	System.out.println("Local port: " + request.getLocalPort() + "\t Server port: " + request.getServerPort());
	
	%>
	<br><br>
	<a href="BooksCart.jsp">Session Example</a>
	
</body>
</html>