package com.odduu.ruhul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.odduu.ruhul.dao.CustomerDAO;
import com.odduu.ruhul.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customerDAO
	@Autowired
	private CustomerDAO customerDAO;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		// get customer from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// add the customer to the model
		// theModel.addAttribute("customers -> name", theModel -> value);
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}

}
