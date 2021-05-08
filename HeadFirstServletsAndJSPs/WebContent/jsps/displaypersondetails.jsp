<%@page import="com.saurabh.java.hfsj.ch01.GlobalHTMLTags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includecss.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 9 - JSTL Set Property Tag</title>
</head>
<body>
<c:import url="/jsps/headerimage.jsp" >
	<c:param value="Java Technology..!" name="subtext"/>
</c:import>
<%= GlobalHTMLTags.doAppendHeading("4", "Details You Entered..")%>

Name: <c:out value="${person1.name}"/><br>
Age: <c:out value="${person1.age}"/><br>
Dog's Name: <c:out value="${person1.pet.dogname}"/><br>
Dog's Breed: <c:out value="${person1.pet.breed}"/><br>

Dummy Session ID: <c:out value='${param.dummysession}'></c:out>

<c:remove var="person1" scope="session"/>

</body>
</html>