package com.odduu.ruhul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.odduu.ruhul.entity.Customer;
import com.odduu.ruhul.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	CustomerService customerService;

	// display list-customer
	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		// get customer from the service
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customer to the model
		// theModel.addAttribute("customers -> name", theModel -> value);
		theModel.addAttribute("customers", theCustomers);

		return "list-customer";
	}

	// display customer-form (Add Customer)
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	// save customer -> customer-form (Add Button)
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	// mapping for "/customer/showFormForUpdate"
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customeId") int theId, Model theModel) {
		
		// get the customer from the database
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form
		return "customer-form";
	}
}
