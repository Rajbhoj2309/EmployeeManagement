package com.employeemanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "deptemp")
//@IdClass(com.employeemanagement.model.DeptEmp.class)
public class DeptEmp  implements Serializable{

	@Id
	@Column(name = "empno",nullable = false)
	private int empno;
	@Id
	@Column(name = "deptno",columnDefinition = "CHAR(4)",nullable = false)
	private String deptno;

	@Column(name = "fromdate",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fromdate;
	
	@Column(name = "todate",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date todate;
	
	@JsonBackReference
	@ManyToOne
//	@JoinColumn(name = "empno", insertable = false, updatable = false)
	 @JoinColumn(name = "empno", referencedColumnName = "empno", insertable = false, updatable = false)
	private Employees employees;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "deptno",  referencedColumnName = "deptno",insertable = false, updatable = false)
	private Departments departments;

	public DeptEmp() {
	}

	public DeptEmp(int empNo, String deptno, Date fromdate, Date todate) {
		super();
		this.empno = empNo;
		this.deptno = deptno;
		this.fromdate = fromdate;
		this.todate = todate;
	}

	public DeptEmp(int empNo, String deptno, Date fromdate, Date todate, Employees employee) {
		super();
		this.empno = empNo;
		this.deptno = deptno;
		this.fromdate = fromdate;
		this.todate = todate;
		this.employees = employee;
	}

	public DeptEmp(int empNo, String deptno, Date fromdate, Date todate, Departments department) {
		super();
		this.empno = empNo;
		this.deptno = deptno;
		this.fromdate = fromdate;
		this.todate = todate;
		this.departments = department;
	}
	
	

	public DeptEmp(int empNo, String deptno, Date fromdate, Date todate, Employees employee, Departments department) {
		super();
		this.empno = empNo;
		this.deptno = deptno;
		this.fromdate = fromdate;
		this.todate = todate;
		this.employees = employee;
		this.departments = department;
	}

	public int getEmpNo() {
		return empno;
	}

	public void setEmpNo(int empNo) {
		this.empno = empNo;
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
		return employees;
	}

	public void setEmployee(Employees employee) {
		this.employees = employee;
	}

	public Departments getDepartment() {
		return departments;
	}

	public void setDepartment(Departments department) {
		this.departments = department;
	}

	@Override
	public String toString() {
		return "DeptEmp [empNo=" + empno + ", deptno=" + deptno + ", fromdate=" + fromdate + ", todate=" + todate
				+ ", employee=" + employees + ", department=" + departments + "]";
	}

	
}
