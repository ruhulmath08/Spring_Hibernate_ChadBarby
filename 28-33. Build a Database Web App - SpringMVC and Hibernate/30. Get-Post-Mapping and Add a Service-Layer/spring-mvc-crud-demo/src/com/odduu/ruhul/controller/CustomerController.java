package com.odduu.ruhul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.odduu.ruhul.entity.Customer;
import com.odduu.ruhul.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		// get customer from the service
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customer to the model
		// theModel.addAttribute("customers -> name", theModel -> value);
		theModel.addAttribute("customers", theCustomers);

		return "list-customer";
	}

}
