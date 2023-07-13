package com.nagarro.ritesh.Application2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ritesh.Application2.services.FailureServices;
import com.nagarro.ritesh.Application2.models.*;

@RestController
@RequestMapping("/backendserver2/failure")
public class FailureController {

	
	
	@Autowired
	private FailureServices failureServices;
	
	
	@GetMapping("/{accountnumber}")
	public List<Transactions> getTransactions(@PathVariable String accountnumber){
		
		List<Transactions> trans = this.failureServices.getTransactions(accountnumber);
		return trans;
		
	}
}
