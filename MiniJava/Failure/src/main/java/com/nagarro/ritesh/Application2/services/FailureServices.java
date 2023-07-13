package com.nagarro.ritesh.Application2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nagarro.ritesh.Application2.repository.FailureRepo;
import com.nagarro.ritesh.Application2.models.*;

@Controller
public class FailureServices {
	
	
	@Autowired
	private FailureRepo failureRepo;
	
	
	public List<Transactions> getTransactions(String accNum){
		
		List<Transactions> transList;
		
		transList = this.failureRepo.findByAccountNumberAndStatus(accNum, "failure");
		
		return transList;
		
		
	}
	

}
