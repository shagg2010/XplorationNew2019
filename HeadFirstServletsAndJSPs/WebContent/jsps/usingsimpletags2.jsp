<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="simple" uri="SimpleTags" %>   
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includecss.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 10 - Simple Tags with Dyanamic Attributes</title>
</head>
<body>
<c:import url="/jsps/headerimage.jsp" >
	<c:param value="Java Technology..!" name="subtext"/>
</c:import>

<br>
<b>Select a movie from the custom dropbox: </b> <br>
<simple:simple7 name='moviecombobox' options='${movieList}' onfocus='donothing();'/>

<br><br>
<d:dynamicselect name="movieselectbox" options="${movieList}" onclick='donothing();'/>

</body>
</html>