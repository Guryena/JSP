<%@page import="Grade.Grade"%>
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
		String getKor = request.getParameter("kor");
			String getEng = request.getParameter("eng");
			String getMath = request.getParameter("math");
			
			double kor = Double.valueOf(getKor);
			double eng = Double.valueOf(getEng);
			double math = Double.valueOf(getMath);
			
			Grade grade = new Grade(kor, eng, math);
	%>
	
		국어 <%=kor %><br>
		영어 <%=eng %><br>
		수학 <%=math %><br>
		총점 <%=grade.getSum() %><br>
		평균 <%=grade.getAvg() %><br>
		등급 <%=grade.getGrade() %><br>
</body>
</html>