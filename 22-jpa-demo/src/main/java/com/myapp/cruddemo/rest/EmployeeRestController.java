package com.myapp.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.cruddemo.entity.Employee;
import com.myapp.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
/*................................................................*/
	
	//private EmployeeDAO employeeDAO;
	
	// Quick and dirty : inject employee dao
	// Using constructor injection
	//@Autowired
	//public EmployeeRestController (EmployeeDAO theEmployeeDAO) {
	//	employeeDAO=theEmployeeDAO;
	//}
	
/*................................................................*/
	
	private EmployeeService employeeService;
	
	// constructor injection
	@Autowired
	public EmployeeRestController (EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	// Expose "/employees" endpoint and return list of employees 
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	// add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		
		return theEmployee;
	}

	// Add mapping for POST /employees - to add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		// Also just in case they pass an id in JSON ... set id to 0
		// This is to force a save of new item ... instead of update
		
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	// Add PUT mapping /employee to update the existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	// Add mapping for DELETE /employees/{employeeId} - delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
	
		// Throw exception if null
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found"+employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id "+ employeeId;
	}
	
	
} 




