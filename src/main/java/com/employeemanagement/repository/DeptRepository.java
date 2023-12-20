package com.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.model.Departments;

public interface DeptRepository extends JpaRepository<Departments, String>{

}
