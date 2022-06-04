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

		// Save/update the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Now retriece/read from database using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
				
	}

	@Override
	public void deleteCustomer(int theId) {

		// Get the current hinernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Delete the customer using primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
