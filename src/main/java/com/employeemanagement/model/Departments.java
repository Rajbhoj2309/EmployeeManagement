package com.employeemanagement.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity()
@Table(name ="departments")
public class Departments implements Serializable{
	
	@Id
	@Column(name="deptno",columnDefinition = "CHAR(4)",nullable = false)
	private String deptNo;
	
	@Column(name="deptname",columnDefinition = "VARCHAR(40)",nullable = false,unique = true)
	private String deptName;
	
	@JsonManagedReference
	 @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
	 private Set<DeptEmp> employees;
	
	public Departments() {
		
	}
	
	public Departments(String deptNo,String deptName) {
		this.deptNo=deptNo;
		this.deptName=deptName;
		
	}

	public Departments(String deptNo, String deptName, Set<DeptEmp> employees) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.employees = employees;
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

	public Set<DeptEmp> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<DeptEmp> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Departments [deptNo=" + deptNo + ", deptName=" + deptName + ", employees=" + employees + "]";
	}


}
