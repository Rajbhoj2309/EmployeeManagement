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

import com.employeemanagement.model.Departments;
import com.employeemanagement.repository.DeptRepository;


@RestController
@RequestMapping("/dept")
public class DeptController {
	
	
	private  final DeptRepository deptRepository;
	@Autowired
	public DeptController(DeptRepository deptRepository) {
		this.deptRepository=deptRepository;
	}
	
	@GetMapping("/{deptNo}")
    public ResponseEntity<Optional<Departments>> getservice(@PathVariable("deptNo") String deptNo) {

        Optional<Departments> list = this.deptRepository.findById(deptNo);
        
        if (!list.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
//            return ResponseEntity.ok(list);
        	return ResponseEntity.of(Optional.of(list));
        }
        
//        return ResponseEntity.of(Optional.of(list));
    }
	
	@GetMapping("/getAll")
    public ResponseEntity<List<Departments>> getAllDepartments() {
        List<Departments> departments = this.deptRepository.findAll(Sort.by(Sort.Direction.ASC, "deptNo"));

        if (departments.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
//            return ResponseEntity.ok(departments);
        	return ResponseEntity.of(Optional.of(departments));
        }
    }
	
	 @PostMapping("/add")
	    public ResponseEntity<Departments> createDepartment(@RequestBody Departments department) {
	        if (department != null) {
	            Departments createdDepartment = deptRepository.save(department);
	            return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
	        } else {
	            return ResponseEntity.badRequest().build();
	        }
	    }
	
	 @PutMapping("/update/{deptNo}")
	    public ResponseEntity<Departments> updateDepartment(
	            @PathVariable("deptNo") String deptNo,
	            @RequestBody Departments updatedDepartment
	    ) {
	        // Check if the department exists in the database
	        if (!deptRepository.existsById(deptNo)) {
	            return ResponseEntity.notFound().build();
	        }

	        updatedDepartment.setDeptNo(deptNo); // Set the department ID from the path variable
	        Departments updatedDept = deptRepository.save(updatedDepartment);
	        return ResponseEntity.status(HttpStatus.OK).body(updatedDept);
	    }
	 
	 @DeleteMapping("/delete/{deptNo}")
	    public ResponseEntity<Void> deleteDepartment(@PathVariable("deptNo") String deptNo) {
	        if (deptRepository.existsById(deptNo)) {
	            deptRepository.deleteById(deptNo);
	            return ResponseEntity.status(HttpStatus.OK).build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 @PatchMapping("/patch/{deptNo}")
	    public ResponseEntity<Departments> updateUserPartially(
	            @PathVariable("deptNo") String deptNo,
	            @RequestBody Departments updatedUserInfo) {
	        
	        // Retrieve the Departments by ID
		 Departments existingUser = deptRepository.findById(deptNo).orElse(null);
		 Departments existingUser1=new Departments();
//	        if (existingUser == null) {
//	            return ResponseEntity.notFound().build();
//	        }

	        // Apply partial updates to the existing user
	        // Check which fields are updated and update them individually
	        if (updatedUserInfo.getDeptNo() != null) {
	        	existingUser1.setDeptNo(updatedUserInfo.getDeptNo());
	            existingUser1.setDeptName(updatedUserInfo.getDeptName());
	            Departments save = deptRepository.save(existingUser1);
	            return ResponseEntity.ok(save);
	        }

	        // Save the updated user
	        Departments savedUser = deptRepository.save(existingUser);
	        return ResponseEntity.ok(savedUser);
	    }
	
}
