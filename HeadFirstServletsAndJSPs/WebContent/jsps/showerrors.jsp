<%@ page language="java" isErrorPage="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 7 - Use Error Page in JSP - Errors/Exceptions</title>
</head>
<body>
<h3>Sorry, an internal Server exception/error occurred.</h3> <br>
<jsp:include page="/html/showerrorimage.html"></jsp:include>

<p>Here is the exception: </p>
<pre>
${pageContext['exception']} <br> <br>
${pageContext.exception.message}
</pre>
</body>
</html>