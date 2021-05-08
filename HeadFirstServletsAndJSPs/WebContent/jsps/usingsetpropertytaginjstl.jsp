<%@page import="com.saurabh.java.hfsj.ch09.models.Person"%>
<%@page import="com.saurabh.java.hfsj.ch09.models.Dog"%>
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
	<c:param value="Java Technology!" name="subtext"/>
</c:import>
<% 
Person person = new Person();
Dog pet = new Dog(); 
request.setAttribute("person", person);
request.setAttribute("pet", pet);
%>


<c:set target='${pet}' property='dogname' value='${param.dogname}'/>
<c:set target='${pet}' property='breed'>${param.breed}</c:set>
<c:set target='${person}' property='name' value='${param.name}'/>
<c:set target='${person}' property='age' value='${param.age}'/>

<c:set target='${person}' property='pet' value='${pet}'/>

<c:set var="person1" scope="session" value="${person}"/>

<c:set var="dummysession" value="E2S548754RYTWRF9"/>

<a href="<c:url value='../jsps/displaypersondetails.jsp?dummysession=${dummysession}'/>">Display Details</a>

</body>
</html>