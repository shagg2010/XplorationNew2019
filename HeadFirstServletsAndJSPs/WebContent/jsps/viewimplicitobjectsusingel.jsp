<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsps/showerrors.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/html/includecss.html" ></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 8 - Implicit Objects In EL</title>
</head>
<body>
<jsp:include page="/html/headerimage.html" ></jsp:include> <br>

<font size="5">
         Request Headers:
      </font><p>

      <%-- Loop over the JSTL header implicit object, which is a 
           map --%>
      <c:forEach items="${header}" var="h">
         <ul>
            <%-- Display the key of the current item, which
                 represents the request header name and the
                 current item"s value, which represents the
                 header value --%>
            <li>Header Name: <c:out value="${h.key}"/></li>
            <li>Header Value: <c:out value="${h.value}"/></li>
         </ul>
      </c:forEach>

<br><br>

<font size="5">
         Iterating Over Context Initialization Parameters:
      </font><p>

<%-- Loop over the JSTL initParam implicit object,
           which is a map --%>
<c:forEach items="${initParam}" var="parameter">	
 <ul>
            <%-- Display the key of the current item, which
                 corresponds to the name of the init param --%>
            <li>Name: <c:out value="${parameter.key}"/></li>

            <%-- Display the value of the current item, which
                 corresponds to the value of the init param --%>
            <li>Value: <c:out value="${parameter.value}"/></li>
         </ul>
      </c:forEach>
      
      
<br><br>

<p><font size="5">
         Iterating over Cookies:
      </font><p>	
 <%-- Loop over the JSTL cookie implicit object, which is a 
           map. If there are no cookies, the <c:forEach> action
           does nothing. --%>
      <c:forEach items="${cookie}" var="mapEntry">
         <ul>
            <%-- The mapEntry"s key references the cookie name --%>
            <li>Cookie Name: <c:out value="${mapEntry.key}"/></li>

            <%-- The mapEntry"s value references the Cookie
                 object, so we show the cookie"s value --%>
            <li>Cookie Value: 
                <c:out value="${mapEntry.value.value}"/></li>
         </ul>
      </c:forEach>
      
      <p><font size="5">
         Accessing Cookies Directly:
      </font><p>

      Cookie Objects:
      <ul>
         <li>
            User Name: <c:out value="${cookie['acme.userName'].name}"/>
         </li>
         <li>
            Password:  <c:out value="${cookie['acme.password'].name}"/>
         </li>
      </ul>

      Cookie Values:
      <ul>
         <li>
            User Name: 
            <c:out value="${cookie['acme.userName'].value}"/>
         </li>
         <li>
            Password:  
            <c:out value="${cookie['acme.password'].value}"/>
         </li>
      </ul>
      
      
       <%-- Show Request Information --%>
      <font size="5">Request Information</font><p>

         <%-- Use the request object to show the server port and
                protocol --%>
The current request was made on <b>port 
         <c:out value="${pageContext.request.serverPort}"/></b>	
 with this <b>protocol:
         <c:out value="${pageContext.request.protocol}"/></b>.<br>

         <%-- Use the request object to show the user"s preferred
              locale --%>
         The request <b>locale</b> is 
         <b><c:out value="${pageContext.request.locale}"/>.</b>

         <p>

      <%-- Show Response Information --%>
      <font size="5">Response Information</font><p>

         The response <b>locale</b> is 
         <b><c:out value="${pageContext.response.locale}"/>.</b>

         <%-- Use the response object to show whether the response
              has been committed 
         The <b>response
         <c:choose>
            <c:when test="${pageContext.response.committed}">
               has
            </c:when>

            <c:otherwise>
               has not
            </c:otherwise>
         </c:choose>   
         </b> been committed.

         <p> --%>

      <%-- Show Session Information --%>
      <font size="5">Session Information</font><p>

         Session ID: 
         <b><c:out value="${pageContext.session.id}"/></b><br>
         Max Session Inactive Interval:<b>
         <c:out 
            value="${pageContext.session.maxInactiveInterval}"/> 
         </b>seconds.

         <p>

      <%-- Show Application Information --%>
      <font size="5">Application Information</font><p>
	
 <%-- Store the servlet context in a page-scoped variable
              named app for better readability --%>
         <c:set var="app" value="${pageContext.servletContext}"/>

         <%-- Use the application object to show the major and
              minor versions of the servlet API that the container
              supports --%>
         Your servlet container supports version<b> 
         <c:out 
            value="${app.majorVersion}.${app.minorVersion}"/></b>
         of the servlet API.


</body>
</html>