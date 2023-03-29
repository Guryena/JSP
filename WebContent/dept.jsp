<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	String sql = "SELECT * FROM dept";
	String sqlEMP = "SELECT * FROM EMP";
	String sqlSal = "SELECT ENAME AS 이름, SAL *12 + NVL(COMM, 0) AS 연봉 FROM EMP";
	
	Connection con = DriverManager.getConnection(url, "scott", "tiger");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
	ResultSet rs2 = st.executeQuery(sqlEMP);
	ResultSet rs3 = st.executeQuery(sqlSal);
	
	while(rs.next()){
		out.print(rs.getString("deptno") +" || " + rs.getString("dname") + " || " + rs.getString("loc") + "<br>");
		out.print("<hr>");
	}
	
	while(rs2.next()){
		out.print(rs2.getString("EMPNO") +" || " + rs2.getString("ENAME") + " || " + rs2.getString("JOB") +" || " + 
				rs2.getString("MGR") +" || " +rs2.getString("HIREDATE") +" || " +rs2.getString("SAL") 
				+" || " +rs2.getString("COMM") +" || " +rs2.getString("DEPTNO") +"<br>");
		out.print("<hr>");
	}
	
	while(rs3.next()){
		out.print(rs3.getString("이름")+" || " + rs3.getString("연봉") + "<br>");
		out.print("<hr>");
	}
	
	
	
	rs.close();
	st.close();
	con.close();
	
	
%>
</body>
</html>