<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - More on Implicit Objects In EL</title>
</head>
<body>
<jsp:include page="/html/headerimage.html" ></jsp:include> <br>

Session tracking cookie name is: ${cookie["session-id"].value} <br>

Production Mode: ${initParam["produciton-mode"]}

</body>
</html>