<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="classic" uri="ClassicTags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includecss.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 10 - Classic Tag Handler</title>
</head>
<body>
<c:import url="/jsps/headerimage.jsp" >
	<c:param value="Java Technology..!" name="subtext"/>
</c:import>

<classic:classic1></classic:classic1>
<br> <br>
<classic:classic2>This is the Body with EL - ${10*8} <br></classic:classic2>

<br> <br>
<classic:classic3>This is the Body for Classic Tag 3 <br></classic:classic3>


<br> <br>
<c:set var='movielist' value='${movies}'/>
<table border='1'>
<classic:classic4 movies="${movielist}">
	<tr>
		<td>${movie.name}</td>
		<td>${movie.genre}</td>
	</tr>
</classic:classic4>
</table>

<br> <br>

<classic:classic5>this information will always be displayed in captial letters because of this classic tag</classic:classic5>

</body>
</html>