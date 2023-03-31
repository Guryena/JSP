package edu.global.ex;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.global.vo.EmpDTO;

public class EmpDAO {
//	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
//	private String uid = "scott";
//	private String upw = "tiger";
	private DataSource dataSourece;
	public EmpDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			Context context = new InitialContext();
			dataSourece = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<EmpDTO> empSelect(){
		List<EmpDTO> listEmpDTO = new ArrayList<EmpDTO>();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM EMP";
			
//			con = DriverManager.getConnection(url, uid, upw);
			con = dataSourece.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				listEmpDTO.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listEmpDTO;
		
	}
}
