package com.ruhul.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addSillyMember() {
		System.out.println(getClass().getName() + ": DOING MY DB WORK: ADDING SILLY MEMBER");
	}
}
