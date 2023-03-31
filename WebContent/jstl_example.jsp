<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="edu.global.vo.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="edu.global.ex.EmpDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력문</title>
</head>
<body>
	
	<%out.print("AAA"); %><br>
	<%="AAA" %><br>
	${"AAA" }<br>
	
	<!-- 출력 -->
	<c:out value="AAA"/><br>
	<c:out value="hello"></c:out><br>
	<c:out value="${'hello'}"></c:out><br>
	<hr>
	<!-- 변수 -->
	<!-- var name1 = "Hong Gildong" -->
	<c:set var="name1" value="Hong"/>
	<c:set var="name2" value="Gildong"/>
	${name1 }<br>
	${name2 }<br>
	<% pageContext.setAttribute("name1", "change"); %>
	${name1 }<br>
	<c:remove var="name1"/>
	${name1 }<br>
	
	<c:if test="${10 < 20 }" var="result1">
			10은 20보다 크다<br>
			</c:if>
			result1 : ${result1 }<br>
	<c:if test="${10 > 20 }" var="result2">
			20은 10보다 크다<br>
			</c:if>
			result2 : ${result2 }<br>
	<hr>
	
	<!-- else if문 -->
	<c:set var="user" value="abcd"/>
	<c:choose>
		<c:when test="${user == 'admin' }">
			관리자 페이지
		</c:when>
		<c:otherwise>
			${user }님 반갑습니다.
		</c:otherwise>
	</c:choose>
	
	<!-- foreach문 -->
	
	<% pageContext.setAttribute("numList", new String[]{"1", "2", "3", "4", "5"}); %>
	<ul>
		<c:forEach var="num" items="${numList }" begin="0" end="3">
			<li>${num }</li>
		</c:forEach>
	</ul>
	<hr>
	<%
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("pineapple");
		fruits.add("kiwi");
		fruits.add("melon");
		pageContext.setAttribute("fruits", fruits);
 	%>
 	<ul>
 		<c:forEach var="fruit" items="${fruits}">
 			<li>${fruit}</li>
 		</c:forEach>
 	</ul>
 	<hr>
 	<%
 		EmpDAO dao = new EmpDAO();
		List<EmpDTO> dto = dao.empSelect();;
		pageContext.setAttribute("dto", dto);
	%>
		
 	<ul>
 		<c:forEach var="emp" items="${dto}">
 			<li>${emp.ename} ||
 			${emp.empno}</li>
 		</c:forEach>
 	</ul>
 	<hr>
 	
 	<%
 		List<Integer> x = new ArrayList<>();
 		List<Integer> y = new ArrayList<>();
 		
 		for(int i = 1; i<10; i++){
 			x.add(i);
 			y.add(i);
 		}
 		pageContext.setAttribute("x", x);
 		pageContext.setAttribute("y", y);
 	%>
 	<ul>
 		<c:forEach var="multiX" items="${x}">
 			${multiX}단
 			<c:forEach var="multiY" items="${y}">
 				<li>${multiX} x ${multiY} = ${multiX * multiY}</li>
 			</c:forEach>
 			<hr>
 		</c:forEach>
 	</ul>
 	
 	<hr>
 	
 	<table border="1">
 		<c:forEach var="multiX" items="${x}">
 			<tr>
 			<c:forEach var="multiY" items="${y}">
 				<td>${multiX} x ${multiY} = ${multiX * multiY}</td>
 			</c:forEach>
 			</tr>
 		</c:forEach>
 	</table>
</body>
</html>