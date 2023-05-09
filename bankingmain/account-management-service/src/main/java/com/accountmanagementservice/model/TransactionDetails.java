package com.accountmanagementservice.model;

public class TransactionDetails {
	private int customerId;
	private int accountNumber;
	private double amount;

	public TransactionDetails() {
		super();
	}

	public TransactionDetails(int customerId, int accountNumber, double amount) {
		super();
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
