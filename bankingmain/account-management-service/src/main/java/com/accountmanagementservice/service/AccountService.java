package com.accountmanagementservice.service;

import com.accountmanagementservice.model.AccountDetails;
import com.accountmanagementservice.model.TransactionDetails;

public interface AccountService {
	public AccountDetails getAccountDetails(int accountNumber);
	public boolean addMoney(TransactionDetails transactionDetails);
	public boolean withdrawMoney(TransactionDetails transactionDetails);
	public boolean deleteAccount(int accountNumber);

}
