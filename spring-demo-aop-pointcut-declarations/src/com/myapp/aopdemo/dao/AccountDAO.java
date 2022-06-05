package com.myapp.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.myapp.aopdemo.Account;

@Component
public class AccountDAO {
//	public void addAccount(Account theAccount) {
//		System.out.println(getClass()+": Doing my DB work : Adding an account.");
//	}
	
	public void addAccount(Account theAccount, boolean vipFLag) {
		System.out.println(getClass()+": Doing my DB work : Adding an account.");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": Doing my work.");
		return false;
	}
}
