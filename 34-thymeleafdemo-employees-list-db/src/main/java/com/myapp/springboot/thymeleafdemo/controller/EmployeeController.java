package com.myapp.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.springboot.thymeleafdemo.entity.Employee;
import com.myapp.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
		
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController (EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	// Add mapping for "/list" 
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// Get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// Add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
