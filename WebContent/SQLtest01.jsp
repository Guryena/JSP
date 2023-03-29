<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
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
		
		String sql = "SELECT ENAME AS 사원명, SAL AS 급여, GRADE AS 등급 FROM EMP E, SALGRADE SG WHERE E.SAL BETWEEN SG.LOSAL AND HISAL";
		
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			out.print(rs.getString("사원명") +"\t" + rs.getString("급여")+"\t" +rs.getString("등급"));
			out.print("<hr>");
		}
		
		rs.close();
		st.close();
		con.close();
	%>
</body>
</html>