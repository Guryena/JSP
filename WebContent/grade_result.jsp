<%@page import="java.io.PrintWriter"%>
<%@page import="servletEx02.grade.Grade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>grade_result</title>
</head>
<body>
	<%
				
		String getKor = request.getParameter("kor".trim()); //trim() removes meaningless spaces 
		String getEng = request.getParameter("eng".trim());
		String getMath = request.getParameter("math".trim());
		
		double kor = Double.valueOf(getKor);
		double eng = Double.valueOf(getEng);
		double math = Double.valueOf(getMath);
		
		
		Grade grade = new Grade(kor, eng, math);
		double sum = grade.getSum();
		double avg = grade.getAvg();
		char chgrade = grade.getGrade();
	%>
		
		합계 : <%= sum %>
		평균 : <%= avg %>
		등급 : <%= chgrade %>
	
</body>
</html>