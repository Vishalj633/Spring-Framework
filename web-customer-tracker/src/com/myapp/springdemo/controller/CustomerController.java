package com.myapp.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.springdemo.dao.CustomerDAO;
import com.myapp.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Need to inject the CustomerDAO 
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get the customers from DAO
		List<Customer>theCustomers=customerDAO.getCustomers();
		
		// Add the customers to the Model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}

}
