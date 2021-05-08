<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 9 - JSTL foreach and if tags</title>
</head>
<body>
<jsp:include page="/jsps/headerimage.jsp" >
	<jsp:param value="Java Technology!" name="subtext"/>
</jsp:include>
Movie List <br>
<table>
<c:forEach var="movie" items="${movies}" varStatus="i">	
	<tr>
	<td width="15px"><c:out value='${i.count}' escapeXml='true'/></td>
	<td> 
	${movie}
	<c:if test="${movie eq 'Leap Year'}">
		&nbsp; (Romantic Comedy)
	</c:if>
	<td>	
	</tr>
</c:forEach>
</table>

</body>
</html>