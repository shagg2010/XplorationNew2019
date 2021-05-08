<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors2.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includecss.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 9 - Error Pages with Exception Type - Webpage</title>
</head>
<body>
<c:import url="/jsps/headerimage.jsp" >
	<c:param value="Java Technology..!" name="subtext"/>
</c:import>
About to do something bad...  <br>
<c:catch var='AException'>
<% int x=10/0; %>
</c:catch>

<!-- if you remove the c:catch the showerrors2.jsp is displayed with the error message :) -->
<c:if test="${AException != null}">
	There was an exception: ${AException.message}
</c:if>
</body>
</html>