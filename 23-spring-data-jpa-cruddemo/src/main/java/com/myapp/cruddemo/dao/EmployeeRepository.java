package com.myapp.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// Thats it No need to write any code
	// will get findAll(), findById(), save(), deleteById() by default through spring

}
