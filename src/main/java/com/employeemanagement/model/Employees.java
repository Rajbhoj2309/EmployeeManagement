package com.employeemanagement.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


//@IdClass(com.employeemanagement.model.Employees.class)
@Entity
@Table(name = "employees")
public class Employees implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="empno",nullable = false)
	private int empno;
	@Column(name="birthdate",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Column(name="firstname",columnDefinition = "VARCHAR(14)",nullable = false)
	private String firstname;
	
	@Column(name="lastname",columnDefinition = "VARCHAR(16)",nullable = false)
	private String lastname;
	
	@Column(name="gender",columnDefinition = "ENUM('M','F')",nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	public enum Gender{
		M,
		F
	}
	@Column(name="hiredate",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date hiredate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employees",cascade = CascadeType.ALL)
	    private List<DeptEmp> deptemp;
	public Employees() {
		
	}
	
	public Employees(Integer empNo, Date birthDate, String firstName, String lastName, Gender gender, Date hireDate) {
		super();
		this.empno = empNo;
		this.birthdate = birthDate;
		this.firstname = firstName;
		this.lastname = lastName;
		this.gender = gender;
		this.hiredate = hireDate;
	}
	public Employees(int empno, Date birthdate, String firstname, String lastname, Gender gender, Date hiredate,
			List<DeptEmp> deptemp) {
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hiredate;
	}

	public void setHireDate(Date hireDate) {
		this.hiredate = hireDate;
	}

	public List<DeptEmp> getDeptemp() {
		return deptemp;
	}

	public void setDeptemp(List<DeptEmp> deptemp) {
		this.deptemp = deptemp;
	}

	@Override
	public String toString() {
		return "Employees [empno=" + empno + ", birthdate=" + birthdate + ", firstname=" + firstname + ", lastname="
				+ lastname + ", gender=" + gender + ", hiredate=" + hiredate + ", deptemp=" + deptemp + "]";
	}

	
	
}
