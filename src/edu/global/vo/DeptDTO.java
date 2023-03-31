package edu.global.vo;

import java.util.Random;

//이름     널?       유형           
//------ -------- ------------ 
//DEPTNO NOT NULL NUMBER(2)    
//DNAME           VARCHAR2(14) 
//LOC             VARCHAR2(13) 
public class DeptDTO {
	public DeptDTO() {
	}

	private int deptno;
	private String dname;
	private String loc;
	
	public DeptDTO(int dept, String dname, String loc) {
		this.deptno = dept;
		this.dname = dname;
		this.loc = loc;
		
	}
	
	public int ran() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
