package com.ruhul.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.ruhul.aopdemo.Account;

@Component
public class AccountDAO {

	public void addSillyMember(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+ ": DOING MY DB WORK: ADDING SILLY MEMBER");
	}
}
