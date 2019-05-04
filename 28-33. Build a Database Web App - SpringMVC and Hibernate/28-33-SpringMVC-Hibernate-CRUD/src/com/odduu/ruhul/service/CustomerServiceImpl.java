package com.odduu.ruhul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odduu.ruhul.dao.CustomerDAO;
import com.odduu.ruhul.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustommers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {		
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustommer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}
}
