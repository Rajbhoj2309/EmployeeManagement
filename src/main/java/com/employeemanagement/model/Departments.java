package com.employeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity()
@Table(name ="departments")
public class Departments {
	
	@Id
	@Column(name="deptno")
	String deptNo;
	
	@Column(name="deptname")
	String deptName;
	
	public Departments() {
		
	}
	
	public Departments(String deptNo,String deptName) {
		this.deptNo=deptNo;
		this.deptName=deptName;
		
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Departments [deptNo=" + deptNo + ", deptName=" + deptName + "]";
	}
	
}
