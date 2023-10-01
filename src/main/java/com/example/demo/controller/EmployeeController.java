package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;


//just to tell that it is our controller
@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeerepository;
	@PostMapping("/employees")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeerepository.save(employee);
		return "Inserted Successfully";
	}
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> empList=new ArrayList<>();
		employeerepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getAllEmployeesById(@PathVariable Long empid){
		Optional<Employee> emp=employeerepository.findById(empid);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
		}
		else return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/employees/{empid}")
	public String updateVal(@PathVariable Long empid) {
		Optional<Employee> emp=employeerepository.findById(empid);
		if(emp.isPresent()) {
			Employee enw=emp.get();
			return "success";
		}
		return "Not success";
	}
	

}
