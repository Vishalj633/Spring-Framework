package com.myapp.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.cruddemo.dao.EmployeeRepository;
import com.myapp.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	// constructor injection
	@Autowired
	public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository) {
		employeeRepository=theEmployeeRepository;
	}
	
	
	@Override
//	@Transactional remove this as jpa repository provide this functionality
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// We didn't find the employee
			throw new RuntimeException("Did not find employee id "+ theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		employeeRepository.save(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {

		employeeRepository.deleteById(theId);
		
	}

}
