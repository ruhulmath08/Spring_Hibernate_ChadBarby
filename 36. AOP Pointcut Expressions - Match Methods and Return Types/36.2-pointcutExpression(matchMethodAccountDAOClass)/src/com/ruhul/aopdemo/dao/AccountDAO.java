package com.ruhul.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass().getName() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
}
