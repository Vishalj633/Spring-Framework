package com.myapp.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
//	public void addAccount() {
//		System.out.println(getClass()+" : Adding membership");
//	}
	
//	public void addUpdate() {
//		System.out.println(getClass()+" : Adding update to membership");
//	}
	
	public boolean addUpdate() {
		System.out.println(getClass()+" : Adding update to membership");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass()+" : Sleeping");
	}
}
