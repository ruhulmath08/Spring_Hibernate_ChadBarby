package com.odduu.ruhul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odduu.ruhul.dao.CustomerDAO;
import com.odduu.ruhul.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject CustomerDAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getCustomers() {
		return null;
	}

}
