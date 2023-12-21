package com.employeemanagement.model;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="empno")
	private int empno;
	@Column(name="birthdate")
	private Date birthdate;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="gender")
	private String gender;	
	
	@Column(name="hiredate")
	private Date hiredate;
	
	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	    private Set<DeptEmp> deptemp;
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
	public Employees(int empno, Date birthdate, String firstname, String lastname, String gender, Date hiredate,
			Set<DeptEmp> deptemp) {
		super();
		this.empno = empno;
		this.birthdate = birthdate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.hiredate = hiredate;
		this.deptemp = deptemp;
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

	public Set<DeptEmp> getDeptemp() {
		return deptemp;
	}

	public void setDeptemp(Set<DeptEmp> deptemp) {
		this.deptemp = deptemp;
	}

	@Override
	public String toString() {
		return "Employees [empno=" + empno + ", birthdate=" + birthdate + ", firstname=" + firstname + ", lastname="
				+ lastname + ", gender=" + gender + ", hiredate=" + hiredate + ", deptemp=" + deptemp + "]";
	}

	
	
}
