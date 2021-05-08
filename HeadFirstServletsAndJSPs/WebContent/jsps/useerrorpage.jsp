<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 7 - Use Error Page in JSP</title>
</head>
<body>
<% String jsessionid = request.getParameter("jsessionid"); 
	if(jsessionid==null){
		throw new RuntimeException("jsessionid is null");
	}
	else{  
		System.out.println("jsessionid: " + jsessionid);
		%>
		<br> jsessionid = <%= jsessionid %>
		<%
	}
	 %>

</body>
</html>