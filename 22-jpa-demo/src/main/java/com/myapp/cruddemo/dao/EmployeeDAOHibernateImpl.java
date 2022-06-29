package com.myapp.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// Define field for EntityManager
	private EntityManager entityManager;
	
	// Set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl (EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	
	@Override
//	@Transactional  // manages the transaction, no need to start or commit the transaction
// removed 	@Transactional we will add a service to handle it
	public List<Employee> findAll() {
		
		//	Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Create a query
		// using native hebernate API
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee",Employee.class);
		
		// Execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Get the Employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		// return the Employee
		
		return theEmployee;
	}


	@Override
	public void save(Employee theEmployee) {
		
		// Get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Save the employee
		currentSession.saveOrUpdate(theEmployee); // if id is 0 then save/insert else update
		
		
	}


	@Override
	public void deleteById(int theId) {
		
		// Get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Delete object by with primary key
		Query theQuery =
				currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}




