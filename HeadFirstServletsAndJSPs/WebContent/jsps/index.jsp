<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK rel='stylesheet' type='text/css' href='resources/cssstyle.css'>
<title>Head First Servlets and JSP</title>
</head>
<body>
<img alt="Java Logo" src="resources/java-loading.jpg" align="top" width="50" height="50">
	<form action="FrontServletController" method="post">
		<table border="0">
			<tr>
				<td colspan="3"><h5>Head First Exercise You Wish to Execute:</h5></td>
			</tr>
			<tr align="left">
				<td>
					<table>
						<tr>
							<td><input type="radio" name="exercise" value="ch1" /></td>
							<td>Chapter 1 - Servlet 1</td>

						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch3" /></td>
							<td>Chapter 3 - Select Beer</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch4_1" /></td>
							<td>Chapter 4 - Download Jar</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch4_2" /></td>
							<td>Chapter 4 - Redirect Google</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch5_1" /></td>
							<td>Chapter 5 - Servlet Init Parameters</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch5_2" /></td>
							<td>Chapter 5 - Context Parameters</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch5_3" /></td>
							<td>Chapter 5 - ServletContextListener</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch5_4" /></td>
							<td>Chapter 5 - HttpSessionBindingListener</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch5_5" /></td>
							<td>Chapter 5 - ServletContextAttributeListener</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch5_6" /></td>
							<td>Chapter 5 - ServletRequestListener</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch5_7" /></td>
							<td>Chapter 5 - ServletRequestAttributeListener</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch6_1" /></td>
							<td>Chapter 6 - Verify New Session</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch6_2" /></td>
							<td>Chapter 6 - Old Sessions</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch6_3" /></td>
							<td>Chapter 6 - URL Rewriting for Session Tracking</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch6_4" /></td>
							<td>Chapter 6 - Cookies</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch6_5" /></td>
							<td>Chapter 6 - HttpSessionListener</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch6_6" /></td>
							<td>Chapter 6 - HttpSessionAttributeListener</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch6_7" /></td>
							<td>Chapter 6 - HttpSession Attributes</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch6_8" /></td>
							<td>Chapter 6 - View All Listeners (Text Only)</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch7_1" /></td>
							<td>Chapter 7 - JSP Webpage Counter</td>
						</tr>
					</table>
				</td>
				<td>
					<table>						
						<tr>
							<td><input type="radio" name="exercise" value="ch7_2" /></td>
							<td>Chapter 7 - JSP's All Scopes</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch7_3" /></td>
							<td>Chapter 7 - JSPs Init Parameters</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch7_4" /></td>
							<td>Chapter 7 - Error Page in JSPs</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_1" /></td>
							<td>Chapter 8 - EL and JSP Actions</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_2" /></td>
							<td>Chapter 8 - More on EL</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_3" /></td>
							<td>Chapter 8 - EL Operators - [] and .</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_4" /></td>
							<td>Chapter 8 - EL - Using Maps</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_5" /></td>
							<td>Chapter 8 - Request Parameters In EL</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_6" /></td>
							<td>Chapter 8 - Implicit Objects In EL</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_7" /></td>
							<td>Chapter 8 - More on Implicit Objects In EL</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_8" /></td>
							<td>Chapter 8 - TLDs using EL</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_9" /></td>
							<td>Chapter 8 - EL Operators</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch8_10" /></td>
							<td>Chapter 8 - JSP Forward Action</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch9_1" /></td>
							<td>Chapter 9 - JSTL foreach and if tags</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch9_2" /></td>
							<td>Chapter 9 - JSTL choose tag</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch9_3" /></td>
							<td>Chapter 9 - JSTL Set Property Tag</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch9_4" /></td>
							<td>Chapter 9 - Error Pages with Exception Type</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch9_5" /></td>
							<td>Chapter 9 - Introduction to Custom Tags</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch10_1" /></td>
							<td>Chapter 10 - Tag Files</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch10_2" /></td>
							<td>Chapter 10 - Simple Tag Handler</td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td><input type="radio" name="exercise" value="ch10_3" /></td>
							<td>Chapter 10 - SkipPageException Usage</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch10_4" /></td>
							<td>Chapter 10 - Classic Tag Handler</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch10_5" /></td>
							<td>Chapter 10 - Simple Tags with Dyanamic Attributes</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch11_1" /></td>
							<td>Chapter 11 - Servlet Mappings</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch12_1" /></td>
							<td>Chapter 12 - Authorization using Roles/Memory Realm</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch12_2" /></td>
							<td>Chapter 12 - Programmatic Security</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch13_1" /></td>
							<td>Chapter 13 - Using Filters</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch13_2" checked/></td>
							<td>Chapter 13 - Using Servlet Wrappers</td>
						</tr>
						<tr>
							<td><input type="radio" name="exercise" value="ch13_3" checked/></td>
							<td>Chapter 13 - Using Servlet Filters and Wrappers</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="Go" />
				</td>
			<tr>
		</table>
	</form>
</body>
</html>