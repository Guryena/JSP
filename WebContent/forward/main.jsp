<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- forward is change -->
	<h1>메인페이지 입니다</h1>
	<%
		System.out.println("헤드 태그");
	%>


	<jsp:forward page="sub.jsp" />
	<%
		System.out.println("중간 태그");
	%>

	<h3>꼬릿말 입니다</h3>
	<%
		System.out.println("꼬리 태그");
	%>

</body>
</html>