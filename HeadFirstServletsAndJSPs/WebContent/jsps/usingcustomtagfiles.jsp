<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="css" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - Introduction to EL</title>
</head>
<body>
<c:import url="/jsps/headerimage.jsp" >
	<c:param value="Java Technology..!" name="subtext"/>
</c:import>
<css:headermessage message="Hello World using a Tag file attribute!" color="#660099"/>
<pre><a href="#"> <css:headermessage2>Hello World using a Tag File body</css:headermessage2> </a></pre>
</body>
</html>