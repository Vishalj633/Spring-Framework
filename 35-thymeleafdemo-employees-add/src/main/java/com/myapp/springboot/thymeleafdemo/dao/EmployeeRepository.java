package com.myapp.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// Thats it No need to write any code
	// will get findAll(), findById(), save(), deleteById() by default through spring
	
	// Add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc(); // Spring JPA will parse the method name // Looks for specific format and pattern creates appropriate query  behind the scenes
}
