package com.cg.dto;

public class AccountForm {

	private String accountName;
	private double balance;
	private String customerID;
	
	public AccountForm(String accountName, double balance, String customerID) {
		super();
		this.accountName = accountName;
		this.balance = balance;
		this.customerID = customerID;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	
	
}
