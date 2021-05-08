<%@page import="com.saurabh.java.hfsj.ch01.GlobalHTMLTags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% out.println(GlobalHTMLTags.doAppendCSSFile("resources/cssstyle.css")); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 7 - Intro to JSPs</title>
</head>
<body>
<%! int count=0;  %>
<%! String appendString(int count){
	return "Total visits to this page: " + count;
}
%>

<h3> <%= appendString(++count) %> </h3>
</body>
</html>