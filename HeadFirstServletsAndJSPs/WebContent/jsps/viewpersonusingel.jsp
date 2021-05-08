<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - Introduction to EL</title>
</head>
<body>
<jsp:include page="/html/headerimage.html" ></jsp:include> <br>

<jsp:useBean id="person" class="com.saurabh.java.hfsj.ch08.models.Person" type="com.saurabh.java.hfsj.ch08.models.IPerson" scope="request">
	<!-- this setProperty works only if the person is null (from the request scope) -->
	<jsp:setProperty name="person" property="name" value="Saurabh Yadav"/>
	<jsp:setProperty name="person" property="age" value="28"/>
</jsp:useBean>

Name: <jsp:getProperty name="person" property="name"/> <br>
Age: ${person.age}

</body>
</html>