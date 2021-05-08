<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - EL Operators</title>
</head>
<body>
hakona-matata<br>
<jsp:include page="/jsps/headerimage.jsp" >
	<jsp:param value="Java Technology!" name="subtext"/>
</jsp:include> 

num&gt;3: ${num>3} <br>
integer le 12: ${integer le 12} <br>
requestScope["integer"] ne 4 and 6 le num || false: ${requestScope["integer"] ne 4 and 6 le num || false} <br>
list[0] || list["1"] and true: ${list[0] || list["1"] and true} <br>
num &gt; integer: ${num > integer} <br>
num == integer-1: ${num == integer-1} <br>
42 / 1: ${42 / 1} <br>

<jsp:useBean id="dog" class="com.saurabh.java.hfsj.ch08.models.Dog" scope="request">
	<jsp:setProperty name="dog" property="dogname" value="${list[1]}"></jsp:setProperty>
</jsp:useBean>

---> where - dogname = list[1] (false) <br>

dog.dogname and true: ${dog.dogname and true} <br>

empty dog.dogname: ${empty dog.dogname} <br>

empty dog.breed: ${empty dog.breed} <br>

</body>
</html>