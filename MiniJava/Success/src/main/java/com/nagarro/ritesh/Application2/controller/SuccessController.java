package com.nagarro.ritesh.Application2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nagarro.ritesh.Application2.services.SuccessServices;
import com.nagarro.ritesh.Application2.models.*;

@RestController 
@RequestMapping("/backendserver1/success")
public class SuccessController {
	
	
	
	@Autowired
	private SuccessServices successServices;
	
	
	@GetMapping("/{accountNumber}")
	public List<Transactions> getTransactions(@PathVariable String accountNumber){
		
		return this.successServices.getTransactions(accountNumber);
		
	}
	

}
