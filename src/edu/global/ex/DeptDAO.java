package edu.global.ex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import edu.global.vo.DeptDTO;

public class DeptDAO {
//  connection pool 사용으로 인해 주석	
//	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
//	private String uid = "scott";
//	private String upw = "tiger";
	
	private DataSource dataSource; //Connection Pool Object
	
	public DeptDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<DeptDTO> deptSelct(){
		List<DeptDTO> deptDTO = new ArrayList<DeptDTO>();
		
		Connection con = null;
		Statement st = null;
		
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM DEPT";
			
//			con = DriverManager.getConnection(url, uid, upw);
			con = dataSource.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				deptDTO.add(dto);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
		
		return deptDTO;
	}
	
}
