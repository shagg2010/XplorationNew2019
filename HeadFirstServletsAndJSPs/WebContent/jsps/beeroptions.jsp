<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.saurabh.java.hfsj.ch03.BeerExpert,com.saurabh.java.hfsj.ch01.GlobalHTMLTags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beer Expert Advice</title>
</head>
<body>

<%
	System.out.println("log3");
	Boolean requestType = Boolean.FALSE;
	String beerColor = new String("");
	
	try{
		requestType = (Boolean) request.getAttribute("fromServlet");
		beerColor = (String) request.getParameter("color").toString()==null?beerColor:(String) request.getParameter("color").toString();	
	}
	catch(Exception e){
		beerColor="";
		out.println(e.getMessage());
	}
	
	System.out.println("log4");
	if(requestType && !beerColor.equals("")){
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("Selected Beer color is: "+beerColor);
		bodyBuffer.append("<br>Suggestions for your choice are: <br>");
		List<String> brands = new BeerExpert().getBrands(beerColor);
		int i = 0;
		for (String brand : brands) {
			bodyBuffer.append("<br>\n" + (++i) + ". " + brand);
		}
		out.print(bodyBuffer.toString());
	}
	else{
		StringBuffer bodyBuffer = new StringBuffer();
		bodyBuffer.append("Invalid Request becuase it did not originated from Servlet!");
		out.print(bodyBuffer.toString());
	}
%>

</body>
</html>