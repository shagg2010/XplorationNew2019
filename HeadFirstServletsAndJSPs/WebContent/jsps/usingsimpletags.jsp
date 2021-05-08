<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="simple" uri="SimpleTags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includecss.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 10 - Simple Tag Handler</title>
</head>
<body>
<c:import url="/jsps/headerimage.jsp" >
	<c:param value="Java Technology..!" name="subtext"/>
</c:import>
<simple:simple1 color='green' message='Hello World!'/> <br>

<simple:simple2>This is the Simple Tag 2</simple:simple2> <br>

<simple:simple3>Message is: ${message} [Tip # ${10*8}]</simple:simple3> <br><br>

<c:set var='movies1' value='${movieList}' scope="request"/>
<table border='1'>
	<simple:simple4 items='${movies1}'>
		<tr>
			<td>${item}</td>
		</tr>
	</simple:simple4>
</table>

<br><br>

<table border='1'>
	<simple:simple5 movies='${movies}'>
		<tr>
			<td>${movie.name}</td>
			<td>${movie.genre}</td>
		</tr>
	</simple:simple5>
</table>
</body>
</html>