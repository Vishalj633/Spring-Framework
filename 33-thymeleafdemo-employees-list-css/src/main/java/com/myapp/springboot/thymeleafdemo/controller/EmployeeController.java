package com.myapp.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
		
	// Load employee data
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		// create employee
		Employee emp1 = new Employee (1, "Vishal","Jagadale", "vishal@gmail.com");
		Employee emp2 = new Employee (1, "Niti","Ayog", "niti@gmail.com");
		Employee emp3 = new Employee (1, "Ram","Sita", "ram@gmail.com");
		
		// create the list
		theEmployees = new ArrayList<>();
		
		// add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);

	}
	
	// Add mapping for "/list" 
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// Add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
