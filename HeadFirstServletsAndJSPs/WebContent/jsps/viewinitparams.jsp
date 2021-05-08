<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" isErrorPage="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 7 - View Init Context and JSP Parameters</title>
</head>
<body>
	<h3>JSP Init and Context Params-</h3>
	<%! public void jspInit(){
			String email = getServletConfig().getInitParameter("email");
			System.out.println("Email: " + email);
			getServletContext().setAttribute("adminEmail", email);
		}
		%>	
		Param: <%= pageContext.getAttribute("adminEmail", PageContext.APPLICATION_SCOPE) %>
		<br>
		Param: ${applicationScope.adminEmail}
		
</body>
</html>