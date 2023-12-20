package com.employeemanagement.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {
	
	@Id
	@Column(name="empno")
	public int empno;
	@Column(name="birthdate")
	public Date birthdate;
	
	@Column(name="firstname")
	public String firstname;
	
	@Column(name="lastname")
	public String lastname;
	
	@Column(name="gender")
	public String gender;	
	
	@Column(name="hiredate")
	public Date hiredate;
	
	public Employees() {
		
	}

	public Employees(Integer empNo, Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
		super();
		this.empno = empNo;
		this.birthdate = birthDate;
		this.firstname = firstName;
		this.lastname = lastName;
		this.gender = gender;
		this.hiredate = hireDate;
	}

	public Integer getEmpNo() {
		return empno;
	}

	public void setEmpNo(Integer empNo) {
		this.empno = empNo;
	}

	public Date getBirthDate() {
		return birthdate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthdate = birthDate;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hiredate;
	}

	public void setHireDate(Date hireDate) {
		this.hiredate = hireDate;
	}

	@Override
	public String toString() {
		return "Employees [empNo=" + empno + ", birthDate=" + birthdate + ", firstName=" + firstname + ", lastName="
				+ lastname + ", gender=" + gender + ", hireDate=" + hiredate + "]";
	}
	
}
