<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includecss.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 9 - JSTL foreach and if tags</title>
</head>
<body>
<jsp:include page="/jsps/headerimage.jsp" >
	<jsp:param value="Java Technology!" name="subtext"/>
</jsp:include>
<em><strong>Your preference is: </strong></em> &nbsp;
<c:choose>
	<c:when test="${param.preference=='Performance'}">Performance</c:when>
	<c:when test="${param['preference']=='Safety'}">Safety</c:when>
	<c:when test="${param.preference=='Maintenance'}">Maintenance</c:when>
	<c:otherwise>No choice</c:otherwise>
</c:choose>

</body>
</html>