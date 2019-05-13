package com.odduu.ruhul.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odduu.ruhul.entity.Customer;

@Repository
public class CustomerDAOImp implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer ...
		currentSession.save(theCustomer);
	}

}
