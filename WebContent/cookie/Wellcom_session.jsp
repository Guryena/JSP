<%@page import="java.util.Enumeration"%>
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
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pw");
	%>

	환영합니다 <%=id%>님<br>
	your pw is	<%=pw%><br>
	<hr>

	<%
		Enumeration enumeration = session.getAttributeNames();

		while (enumeration.hasMoreElements()) {
			String sName = enumeration.nextElement().toString();
			String sValue = (String) session.getAttribute(sName);

			out.print(sName + " : " + sValue + "<br>");

		}

		out.println("--------------------------------------------");
		
		session.removeAttribute("pw"); //Session remove function

		enumeration = session.getAttributeNames();

		while (enumeration.hasMoreElements()) {
			String sName = enumeration.nextElement().toString();
			String sValue = (String) session.getAttribute(sName);

			out.print(sName + " : " + sValue + "<br>");

		}
		
		out.println("--------------------------------------------");
		
		session.invalidate(); //Remove all session
		
		//Search valid session
		if(request.isRequestedSessionIdValid()){
			out.print("session valid");
		}
		else{
			out.print("session invalid");
		}
	%>

</body>
</html>