package com.employeemanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


//@Embeddable
public class empno implements Serializable{
	
	@Column(name = "empno")
    private int empno;

    @Column(name = "deptno")
    private String deptno;
    
    public empno() {
	}

	public empno(int empno, String deptno) {
		super();
		this.empno = empno;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "DeptEmpId [empno=" + empno + ", deptno=" + deptno + "]";
	}
    
    
    

}
