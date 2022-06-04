package com.myapp.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.springdemo.entity.Customer;
import com.myapp.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
//@GetMapping("/customer")
public class CustomerController {
	
	// Need to inject the CustomerDAO 
	//@Autowired
	//private CustomerDAO customerDAO;
	
	// Need to inject our customer service
	@Autowired
	public CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get the customers from DAO
		//List<Customer>theCustomers=customerDAO.getCustomers();
		
		// Get the customers from service
		List<Customer>theCustomers=customerService.getCustomers();
		
		// Add the customers to the Model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	//@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// Create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer) {
		
		// Save the customer using our service
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}

}
