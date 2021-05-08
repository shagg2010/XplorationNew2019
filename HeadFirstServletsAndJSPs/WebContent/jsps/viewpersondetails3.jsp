<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - EL Operators - [] and . </title>
</head>
<body>
<jsp:include page="/html/headerimage.html" ></jsp:include> <br>
<h3>Name: ${person["name"]}</h3>
<h3>Age: ${person.age}</h3>
<h4>Top Hobby: ${person.hobbies["0"]}</h4>
<h4>2nd Hobby: ${person.hobbies[1]}</h4>
<h4>3rd Hobby: ${person.hobbies[2]}</h4>

</body>
</html>