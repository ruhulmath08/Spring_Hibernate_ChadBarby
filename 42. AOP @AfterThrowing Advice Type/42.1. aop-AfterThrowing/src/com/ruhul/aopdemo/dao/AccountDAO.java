package com.ruhul.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ruhul.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	// AOP after returning
	// add new method : findAccounts()
	public List<Account> findAccounts(boolean tripWrie) {
		List<Account> myAccounts = new ArrayList<>();
		
		// for academic purpose ... simulate an exception
		if(tripWrie) {
			throw new RuntimeException("No soup for you!!!");
		}

		// create simple account
		Account temp1 = new Account("Reza", "Silver");
		Account temp2 = new Account("Goni", "Platinum");
		Account temp3 = new Account("Kapil", "Gold");

		// add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		return myAccounts;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode()");
		this.serviceCode = serviceCode;
	}
}