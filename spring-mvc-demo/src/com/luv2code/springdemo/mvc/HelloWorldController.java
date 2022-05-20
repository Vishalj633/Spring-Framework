package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")	// parent mapping
public class HelloWorldController {
	
	// Need a controller method to show the initial HTML form
	@RequestMapping("/showForm")	// sub mapping (relative)
	public String showForm() {
		return "helloworld-form";
	}
	
	// Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// New Controller method to read form data and
	// Add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// Read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// Convert all data to caps
		theName = theName.toUpperCase();
		
		// Create the message
		String result = "Hi! "+theName;
		
		// Add the message model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	// New Controller method to read form data and
	// Add data to model
	// Add @RequestParam bindings 
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName,
			Model model) {
		
		
		// Don't need following code as spring will automatically will do it
		// Read the request parameter from the HTML form
		//String theName = request.getParameter("studentName");
		
		// Convert all data to caps
		theName = theName.toUpperCase();
		
		// Create the message
		String result = "Form the version three"+theName;
		
		// Add the message model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
