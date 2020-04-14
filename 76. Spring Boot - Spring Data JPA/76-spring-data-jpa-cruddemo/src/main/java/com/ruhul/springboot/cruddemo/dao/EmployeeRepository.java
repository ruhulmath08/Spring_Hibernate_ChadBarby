package com.ruhul.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruhul.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
