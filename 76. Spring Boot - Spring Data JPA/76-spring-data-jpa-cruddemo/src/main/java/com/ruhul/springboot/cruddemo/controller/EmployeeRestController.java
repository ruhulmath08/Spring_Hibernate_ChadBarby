package com.ruhul.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruhul.springboot.cruddemo.entity.Employee;
import com.ruhul.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	// quick and dirty: inject employee service
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	// add mapping for GET /employee/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee theEmployee = employeeService.findById(employeeId);

		if (theEmployee == null) {
			System.out.println("----------theEmployee: "+theEmployee);
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		return theEmployee;
	}

	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		theEmployee.setId(0);

		employeeService.save(theEmployee);

		return theEmployee;
	}

	// add mapping for PUT /employees - update existing employee
	@PutMapping("/employees")
	public Employee updatEmployee(@RequestBody Employee theEmployee) {
		
		System.out.println("---------------@PutMapping----------------");
		
		employeeService.save(theEmployee);		

		return theEmployee;
	}

	// add mapping for DELETE /employees/{employeeId} - delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		System.out.println("employeeId: " + employeeId);

		Employee theEmployee = employeeService.findById(employeeId);
		System.out.println("theEmployee: "+theEmployee);

		if (theEmployee == null) {
			System.out.println("----------theEmployee: "+theEmployee);
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		try {
			employeeService.deleteById(employeeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Deleted employee id - " + employeeId;
	}
}
