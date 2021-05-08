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

Music Map: ${musicMap}
<br>
Music: ${musicMap.Ambient}
<br>
Music: ${musicMap["Ambient"]}
<br><br>

Default Music: ${musicMap[Genre]}
<br>
Default Music: ${musicMap.Genre} <!-- this will not work -->
<br>
Default Music: ${musicMap["Genre"]} <!-- this will not work -->
<br><br>

Music Type: ${musicType[0]}
<br>
Music: ${musicMap.musicType[0]} <!-- this will not work -->
<br>
Music: ${musicMap[musicType[0]]}
<br>
Music: ${musicMap[musicType["0"]]}
<br><br>

Music: ${favMusic[numbers[0]]}
<br>
Music: ${favMusic[numbers[0]+1]}
<br>
Music: ${favMusic[numbers["2"]]}
<br>
Music: ${favMusic[numbers[numbers[1]]]}
<br><br>


</body>
</html>