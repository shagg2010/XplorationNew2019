<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - Request Parameters In EL</title>
</head>
<body>
<jsp:include page="/html/headerimage.html" ></jsp:include> <br>

Request parameter name is: ${param.name} <br> 
Request parameter age is: ${param.age} <br>
Request parameter food is: ${param.food} <br><br>

First Food Request parameter is: ${paramValues.food[0]} <br>
Second Food Request parameter is: ${paramValues.food[1]} <br>

Request parameter: ${paramValues.name[0]} <br><br>
Request parameters values: <br>
<c:forEach items="${paramValues}" var="parameter" >
    ${parameter.key} = 
     <c:forEach var='value' items='${parameter.value}'>
               <c:out value='${value}'/>   <br>
            </c:forEach>
</c:forEach>

<br><br>

Header values: <br>

<c:forEach items="${headerValues}" var="headerMap" >
    ${headerMap.key} = 
     <c:forEach var='value' items='${headerMap.value}'>
               <c:out value='${value}'/>   <br>
            </c:forEach>
</c:forEach>


</body>
</html>