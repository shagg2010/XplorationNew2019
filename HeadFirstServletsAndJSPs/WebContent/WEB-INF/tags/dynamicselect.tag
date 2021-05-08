<%@ tag body-content="empty" dynamic-attributes="tagAttrs"%>
<%@ attribute name="options" description="List to be displayed as Select Box" required="true" rtexprvalue="true" type="java.util.List"%> 
<%@ attribute name="name" required="true"%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<select name='${name}' <c:forEach var='attr' items='${tagAttrs}'> ${attr.key}='${attr.value}' </c:forEach>>
	<c:forEach var='option' items='${options}'>
		<option value='${option}'>${option}</option>
	</c:forEach>
</select>