package com.myapp.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl (EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
	
		// Create a Query
		Query theQuery = 
				entityManager.createQuery("from Employee");
		
		// Execute Query and get the result
		List<Employee> employees = theQuery.getResultList();
		
		// return the result
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		// Get employee
		Employee theEmployee =
				entityManager.find(Employee.class, theId);
		
		// Return employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// Save or update the employee 
		Employee dbEmployee =
				entityManager.merge(theEmployee);
		
		// Update with id from DB ... so we can get generated id for save/update
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {

		// Delete the object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();

	}

}
