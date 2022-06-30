package com.myapp.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.myapp.cruddemo.entity.Employee;

// @RepositoryRestResource(path="members")  for custom path /members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// Thats it No need to write any code
	// will get findAll(), findById(), save(), deleteById() by default through spring

}
