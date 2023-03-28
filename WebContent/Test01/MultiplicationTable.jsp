<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for (int x = 1; x < 10; x++) {
			out.println("======"+ x+"단=====<br>");
			for (int y = 1; y < 10; y++) {
				out.println(x + " x " + y + " = "+ x*y +"<br>");
				
				
			}
		}
	%>
	
	
</body>
</html>