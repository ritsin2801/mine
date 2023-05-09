package com.accountmanagementservice.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accountmanagementservice.model.Account;
import com.accountmanagementservice.model.AccountDetails;
import com.accountmanagementservice.model.Customer;
import com.accountmanagementservice.model.TransactionDetails;
import com.accountmanagementservice.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private RestTemplate restTemplate;

	private static List<Account> accounts = new ArrayList<>();

	static {
		accounts.add(new Account(1, 1, 32.23, "classic"));
		accounts.add(new Account(2, 7, 782.64, "premium"));
		accounts.add(new Account(3, 4, 9.57, "classic"));
	}
	
	@Override
	public AccountDetails getAccountDetails(int accountNumber) {
		Account account = null;
		try {
			account = accounts.stream().filter(item -> item.getAccountNumber() == accountNumber).findFirst().get();
		} catch (NoSuchElementException e) {
			return null;
		}
		Customer customer = restTemplate.getForObject(
				"http://customer-management-service/customer/getCustomer/" + account.getCustomerId(), Customer.class);
		if (customer == null) {
			return null;
		}
		return new AccountDetails(account.getAccountNumber(), account.getCustomerId(), account.getAccountBalance(),
				account.getAccountType(), customer.getFirstName(), customer.getLastName(), customer.getAddress(),
				customer.getPhone(), customer.getGender());
	}
	
	@Override
	public boolean addMoney(TransactionDetails transactionDetails) {
		Account account = null;
		try {
			account = accounts.stream().filter(item -> item.getAccountNumber() == transactionDetails.getAccountNumber()).findFirst().get();
		} catch (NoSuchElementException e) {
			return false;
		}
		Customer customer = restTemplate.getForObject(
				"http://customer-management-service/customer/getCustomer/" + transactionDetails.getCustomerId(), Customer.class);
		if (customer == null) {
			return false;
		}
		double accountBalance = account.getAccountBalance();
		account.setAccountBalance(accountBalance + transactionDetails.getAmount());
		return true;
	}
	
	@Override
	public boolean withdrawMoney(TransactionDetails transactionDetails) {
		Account account = null;
		try {
			account = accounts.stream().filter(item -> item.getAccountNumber() == transactionDetails.getAccountNumber()).findFirst().get();
		} catch (NoSuchElementException e) {
			return false;
		}
		Customer customer = restTemplate.getForObject(
				"http://customer-management-service/customer/getCustomer/" + transactionDetails.getCustomerId(), Customer.class);
		if (customer == null) {
			return false;
		}
		double accountBalance = account.getAccountBalance();
		if (transactionDetails.getAmount() <= accountBalance) {
			account.setAccountBalance(accountBalance - transactionDetails.getAmount());
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deleteAccount(int accountNumber) {
		Account account = null;
		try {
			account = accounts.stream().filter(item -> item.getAccountNumber() == accountNumber).findFirst().get();
			accounts.remove(account);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
