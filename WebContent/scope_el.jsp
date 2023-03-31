<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="objectOk.jsp" method="post">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="text" name="pw"><br>
		<input type="submit" value="login">
		
	</form> -->
	
	<%
		application.setAttribute("application_name", "application_value");
		session.setAttribute("session_name", "session_value");
		pageContext.setAttribute("page_name", "page_value");
		request.setAttribute("request_name", "request_valeu");
	%>
	
	pageScope : ${pageScope.page_name }<br>
	//forwarding
	<jsp:forward page="objectOk.jsp"/>
</body>
</html>