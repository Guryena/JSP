<%@page import="edu.global.vo.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	EmpDTO vo = new EmpDTO();
    	vo.setEname("HONG Gildong");
    %>
    <jsp:useBean id="empDTO" class="edu.global.vo.EmpDTO"/>
    <jsp:setProperty name="empDTO" property="ename" value="HONG Gildong"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	${1}<br>
	${1+1}<br>
	${1*2}<br>
	${1-1}<br>
	${1/2}<br>
	${1>2 ? 1:2}<br>
	${1>2 && 1<2 }<br>
	${1>2 || 1<2 }<br>
	
	${10 }<br>
	${9.99 }<br>
	${"abc" }<br>
	${true }<br>
	
	<hr>
	${empDTO.ename }<br>
	
</body>
</html>