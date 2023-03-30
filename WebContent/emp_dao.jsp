<%@page import="edu.global.vo.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="edu.global.ex.EmpDAO"%>
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
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> dto = dao.empSelect();
		
		for(EmpDTO empDTO : dto){
			out.print("사번 : " + empDTO.getEmpno() + "<br>");
			out.print("이름 : " + empDTO.getEname() + "<br>");
			out.print("직업 : " + empDTO.getJob() + "<br>");
			out.print("매니저 : " + empDTO.getMgr() + "<br>");
			out.print("입사일 : " + empDTO.getHiredate() + "<br>"); 
			out.print("봉급 : " + empDTO.getSal() + "<br>");
			out.print("보너스 : " + empDTO.getComm() + "<br>");
			out.print("부서번호 : " + empDTO.getDeptno() + "<br>");
			
			out.print("<hr>");
		}
	%>
</body>
</html>