package com.myapp.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.springdemo.dao.CustomerDAO;
import com.myapp.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	// Need to inject customer DAO
	@Autowired
	private CustomerDAO customerDAO; 
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
		
	}

}
