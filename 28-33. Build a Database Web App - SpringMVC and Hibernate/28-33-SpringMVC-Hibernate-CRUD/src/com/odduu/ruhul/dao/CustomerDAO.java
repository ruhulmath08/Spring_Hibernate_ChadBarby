package com.odduu.ruhul.dao;

import java.util.List;

import com.odduu.ruhul.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustommers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustommer(int theId);

	public void deleteCustomer(int theId);
}
