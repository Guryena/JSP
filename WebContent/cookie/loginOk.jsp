<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id, pw;
	%>
	
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		if(id.equals("abcd") && pw.equals("1234")){
			
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60); //delete after 60s
			
			response.addCookie(cookie);
			response.sendRedirect("Welcom.jsp"); //redirect 는 유저로 하여금 다시 Wlecom.jsp에 접속하게 함
			
		}
		else{
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>