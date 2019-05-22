package com.odduu.ruhul.dao;

import java.util.List;

import com.odduu.ruhul.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

}
