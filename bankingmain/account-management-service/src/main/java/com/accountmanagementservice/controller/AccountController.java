package com.accountmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountmanagementservice.model.AccountDetails;
import com.accountmanagementservice.model.TransactionDetails;
import com.accountmanagementservice.service.AccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping("/getAccount/{accountNumber}")
	public AccountDetails getAccount(@PathVariable("accountNumber") int accountNumber) {
		return accountService.getAccountDetails(accountNumber);
	}

	@PutMapping("/addMoney")
	public boolean addMoney(@RequestBody TransactionDetails transactionDetails) {
		return accountService.addMoney(transactionDetails);
	}

	@PutMapping("/withdrawMoney")
	public boolean withdrawMoney(@RequestBody TransactionDetails transactionDetails) {
		return accountService.withdrawMoney(transactionDetails);
	}

	@DeleteMapping("/deleteAccount/{accountNumber}")
	public boolean deleteAccount(@PathVariable("accountNumber") int accountNumber) {
		return accountService.deleteAccount(accountNumber);
	}

}
