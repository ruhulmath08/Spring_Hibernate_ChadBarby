package com.ruhul.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyMember() {
		
		System.out.println(getClass() + ": Execute -> addSillyMember()");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": Execute -> goToSleep()");
	}
}
