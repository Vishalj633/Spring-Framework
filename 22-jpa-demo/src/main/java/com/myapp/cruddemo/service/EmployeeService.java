package com.myapp.cruddemo.service;

import java.util.List;

import com.myapp.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int Id);

}
