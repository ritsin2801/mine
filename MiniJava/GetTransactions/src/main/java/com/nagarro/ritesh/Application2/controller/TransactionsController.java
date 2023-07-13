package com.nagarro.ritesh.Application2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ritesh.Application2.services.TransactionsServices;
import com.nagarro.ritesh.Application2.models.*;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
	
	@Autowired
	private TransactionsServices transactionServices;
	
	@GetMapping("/{accountnumber}")
	public List<Transactions> getTransactions(@PathVariable String accountnumber,@RequestParam String status){
		
		
		List<Transactions> trans = null;
		
		
		//When status is success
		if(status.equals("success")) {
			
			System.out.println(status);
			trans = this.transactionServices.successTransactions(accountnumber);
		}
		
		else if(status.equals("pending")) {
			trans = this.transactionServices.pendingTransactions(accountnumber);
			
		}
		
		else if(status.equals("failure")) {
			
			trans = this.transactionServices.failureTransactions(accountnumber);
		}
		
		
		return trans;
		
	}
	
	
		
	
}
