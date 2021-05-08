<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK rel="stylesheet" type="text/css" href="resources/cssstyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - JSP Forward Action</title>
</head>
<body>
<jsp:include page="/jsps/headerimage.jsp" >
	<jsp:param value="Java Technology!" name="subtext"/>
</jsp:include>

<em><strong>Welcome to our website</strong></em><br>
<c:if test="${empty param.name} }">
	<jsp:forward page="/jsps/nullusername.jsp"></jsp:forward>
</c:if> 
<em><strong>Your name is: </strong> ${param["name"]}</em>


<!-- 
<% if(request.getParameter("name")==null || request.getParameter("name").equalsIgnoreCase("") || request.getParameter("name").isEmpty()){ %>
	<jsp:forward page="/jsps/nullusername.jsp"></jsp:forward>
<%	
} else{ %>
	<em><strong>Your name is: </strong></em> <%= request.getParameter("name")%>

<% }
%>

 -->
</body>
</html>