package com.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.model.Employees;
import com.employeemanagement.repository.EmployeeRepository;


@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/{empno}")

	ResponseEntity<Employees> getEmployee(@PathVariable("empno") int empno) {

		Optional<Employees> findById = employeeRepository.findById(empno);
		if (!findById.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(findById.get());
	}

	@GetMapping("/sec/{empNo1}")

	ResponseEntity<Optional<Employees>> getEmployee1(@PathVariable("empno1") int empNo1) {

		Optional<Employees> findById = employeeRepository.findById(empNo1);
		if (!findById.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.of(Optional.of(findById));
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employees>> getAllDepartments() {
		List<Employees> employees = this.employeeRepository.findAll();

		if (employees.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
//        return ResponseEntity.ok(departments);
			return ResponseEntity.of(Optional.of(employees));
		}
	}

}
