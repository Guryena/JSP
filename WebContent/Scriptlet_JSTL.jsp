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
		for (int x =1; x <10; x++){
			out.print("=====" + x + "단" + "=====<br />");
			for (int y = 1; y < 10; y++ ){
				out.print(x + " x " + y + " = " + x*y + "<br>");
			}
			
			out.print("<hr>");
		}
	%>




	<%!
		int i = 10;
		String str = "abc";
		
		private int sum (int a, int b){
			return a+b;
		}
	%>

	<%
		out.print("<hr>");
	%>

	<%= i %><br />
	<%= str %><br />
	<%= "합계" + sum(1,5) %><br />
	
	
		
	
</body>
</html>