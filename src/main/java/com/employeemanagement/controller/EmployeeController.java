package com.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/add")
    public ResponseEntity<Employees> createDepartment(@RequestBody Employees employees) {
        if (employees != null) {
        	Employees createdEmployees = employeeRepository.save(employees);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployees);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
	
	@PutMapping("/update/{empno}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable("empno") int empno ,
			@RequestBody Employees employeesUpdate){
		if(!employeeRepository.existsById(empno)) {
			return ResponseEntity.notFound().build();
		}
		employeesUpdate.setEmpNo(empno);
			Employees updateEmployee = employeeRepository.save(employeesUpdate);
		return ResponseEntity.status(HttpStatus.OK).body(updateEmployee);
	}
	
	@DeleteMapping("/delete/{empno}")
	public ResponseEntity<Employees> deleteEmployee(@PathVariable("empno") int empno){
		if(employeeRepository.existsById(empno)) {
			employeeRepository.deleteById(empno);
			return ResponseEntity.status(HttpStatus.OK).build();
		}

		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/patch/{empno}")
	public ResponseEntity<Employees> patchEmployee(@PathVariable("empno")int empno,
				@RequestBody Employees employees){
		
		if(employeeRepository.existsById(empno)) {
			employees.setEmpNo(empno);
			Employees save = employeeRepository.save(employees);
			return ResponseEntity.status(HttpStatus.OK).body(save);
		}else if(!employeeRepository.existsById(empno)) {
			employees.setEmpNo(empno);
			Employees save = employeeRepository.save(employees);
			return ResponseEntity.status(HttpStatus.OK).body(save);
		}
		
		return ResponseEntity.notFound().build();
	}

}
