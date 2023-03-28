<%@page import="javax.websocket.Session"%>
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
			session.setAttribute("id", id);			
			session.setAttribute("pw", pw);			
			
			response.sendRedirect("Wellcom_session.jsp");
		}
		else{
			response.sendRedirect("login_session.jsp");
		}
	%>
</body>
</html>