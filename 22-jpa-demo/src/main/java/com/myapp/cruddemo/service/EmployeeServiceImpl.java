package com.myapp.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.cruddemo.dao.EmployeeDAO;
import com.myapp.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	// constructor injection
	@Autowired
	public EmployeeServiceImpl (
			@Qualifier ("employeeDAOJPAImpl"/* Bean Id is class name with first letter small case*/)
			EmployeeDAO theEmployeeDAO) {
		employeeDAO=theEmployeeDAO;
	}
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {

		employeeDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		employeeDAO.deleteById(theId);
		
	}

}
