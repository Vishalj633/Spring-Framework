package com.myapp.springdemo.service;

import java.util.List;

import com.myapp.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer>getCustomers();

	public void saveCustomer(Customer theCustomer);
}
