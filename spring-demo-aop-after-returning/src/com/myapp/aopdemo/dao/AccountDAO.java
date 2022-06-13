package com.myapp.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myapp.aopdemo.Account;

@Component
public class AccountDAO {
//	public void addAccount(Account theAccount) {
//		System.out.println(getClass()+": Doing my DB work : Adding an account.");
//	}
	
	private String name;
	private String serviceCode;
	
	// Add a new method to findAccounts()
	
	public List<Account> findAccounts(){
		
		List<Account> myAccounts = new ArrayList<>();
		
		// Create some sample accounts
		Account temp1 = new Account ("Vishal", "Gold");
		Account temp2 = new Account ("Saurabh", "silver");
		Account temp3 = new Account ("Tim", "Platium");
		
		// Add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
		
	}
		
	public void addAccount(Account theAccount, boolean vipFLag) {
		System.out.println(getClass()+": Doing my DB work : Adding an account.");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": Doing my work.");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+": In getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": In setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": In getServiceCode.");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": In setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
