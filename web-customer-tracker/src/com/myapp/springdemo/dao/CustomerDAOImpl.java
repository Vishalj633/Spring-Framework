package com.myapp.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		
		// Get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query
		Query<Customer> theQuery = currentSession.createQuery("from customer order by lastName",Customer.class);
		
		// Execute query and get the result
		List<Customer> customers = theQuery.getResultList();
		
		// Return the results
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Save the customer
		currentSession.save(theCustomer);
		
	}

}
