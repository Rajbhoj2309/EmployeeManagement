package com.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer>{

}
