package com.employeemanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.employeemanagement.*;

@Entity
@Table(name = "deptemp")
@IdClass(empno.class)
public class DeptEmp  {

	@Id
	@Column(name = "empno")
	private int empNo;
	@Column(name = "deptno")
	private String deptno;
	@Column(name = "fromdate")
	private Date fromdate;
	@Column(name = "toDate")
	private Date todate;

	@ManyToOne
//	@JoinColumn(name = "empno", insertable = false, updatable = false)
	 @JoinColumn(name = "empno", referencedColumnName = "empno", insertable = false, updatable = false)
	private Employees employee;

	@ManyToOne
	@JoinColumn(name = "deptno",  referencedColumnName = "deptno",insertable = false, updatable = false)
	private Departments department;

	public DeptEmp() {
	}

	public DeptEmp(int empNo, String deptno, Date fromdate, Date todate) {
		super();
		this.empNo = empNo;
		this.deptno = deptno;
		this.fromdate = fromdate;
		this.todate = todate;
	}

	public DeptEmp(int empNo, String deptno, Date fromdate, Date todate, Employees employee) {
		super();
		this.empNo = empNo;
		this.deptno = deptno;
		this.fromdate = fromdate;
		this.todate = todate;
		this.employee = employee;
	}

	public DeptEmp(int empNo, String deptno, Date fromdate, Date todate, Departments department) {
		super();
		this.empNo = empNo;
		this.deptno = deptno;
		this.fromdate = fromdate;
		this.todate = todate;
		this.department = department;
	}
	
	

	public DeptEmp(int empNo, String deptno, Date fromdate, Date todate, Employees employee, Departments department) {
		super();
		this.empNo = empNo;
		this.deptno = deptno;
		this.fromdate = fromdate;
		this.todate = todate;
		this.employee = employee;
		this.department = department;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "DeptEmp [empNo=" + empNo + ", deptno=" + deptno + ", fromdate=" + fromdate + ", todate=" + todate
				+ ", employee=" + employee + ", department=" + department + "]";
	}

	
}
