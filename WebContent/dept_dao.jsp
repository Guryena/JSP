<%@page import="edu.global.vo.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="edu.global.ex.DeptDAO"%>
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
	DeptDAO dao = new DeptDAO();
	List<DeptDTO> dto = dao.deptSelct();
	
	for(DeptDTO deptDTO : dto){
		out.print("부서번호 : " + deptDTO.getDeptno() + "</br>" );
		out.print("장소 : " + deptDTO.getLoc() + "</br>" );
		out.print("부서이름 : " + deptDTO.getDname() + "</br>" );
		out.print("<hr>");
	}
	
%>
</body>
</html>