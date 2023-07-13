package com.nagarro.ritesh.Application2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ritesh.Application2.models.Transactions;
import com.nagarro.ritesh.Application2.services.PendingServices;



@RestController
@RequestMapping("/backendserver3/pending")
public class PendingController {
	
	
	@Autowired
	private PendingServices pendingServices;
	
	@GetMapping("/{accountnumber}")
	public List<Transactions> getTransactions(@PathVariable("accountnumber") String accountNum){
		
		List<Transactions> transL;
		
		try {
			transL= this.pendingServices.getTransactions(accountNum);
		}catch(Exception e) {
			
			transL = new ArrayList<>();
			
		}
		return transL;
	}

	
		@GetMapping
		public List<Transactions> get(){
			
			return this.pendingServices.getAll();
		}
	
}
