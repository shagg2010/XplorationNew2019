<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - Use of JSP Actions</title>
</head>
<body>
<jsp:include page="/html/headerimage.html" ></jsp:include> <br>

<jsp:useBean id="person" class="com.saurabh.java.hfsj.ch08.models.Person2" type="com.saurabh.java.hfsj.ch08.models.IPerson" scope="request">
	<!-- this setProperty picks the request params automatically since the param name is same as property name) -->
	<!-- this setProperty works only if the person is null (in the request scope) -->
	<jsp:setProperty name="person" property="*" />
</jsp:useBean>

Name: <jsp:getProperty name="person" property="name"/> <br>
Age: ${person.age} <br>

Dogs' Name: ${person.pet.dogname} <br>
Dogs' Breed: ${person.pet.breed} <br>
</body>
</html>