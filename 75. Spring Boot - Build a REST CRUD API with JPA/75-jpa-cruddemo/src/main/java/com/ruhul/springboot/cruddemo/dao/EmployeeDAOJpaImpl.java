package com.ruhul.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ruhul.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//create a query
		Query theQuery = entityManager.createQuery("FROM Employee");
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the result
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		//return employee
		return theEmployee;
	}

	//save or update
	@Override
	public void save(Employee theEmployee) {
		
		System.out.println("---------------: " + theEmployee);
		
		//save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update with id from db .. so we can get generated if for save/insert
		theEmployee.setId(dbEmployee.getId());

	}
	

	@Override
	public void deleteById(int theId) {
		
		//delete object with primary key
		Query theQuery = entityManager.createQuery("DELETE FROM Employee WHERE id=:employeeId");

		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
