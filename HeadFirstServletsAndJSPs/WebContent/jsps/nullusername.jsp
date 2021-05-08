<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK rel="stylesheet" type="text/css" href="/resources/cssstyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - JSP Forward Action</title>
</head>
<body>
<jsp:include page="headerimage.jsp" >
	<jsp:param value="Java Technology is Great!" name="subtext"/>
</jsp:include>
<em><strong>Name can't be null!</strong></em>
<a href="../FrontServletController?exercise=ch8_10">Click Here</a> to continue. Or 
<a href="<c:url value='../FrontServletController?exercise=ch8_10'/>">here</a> to continue.
</body>
</html>