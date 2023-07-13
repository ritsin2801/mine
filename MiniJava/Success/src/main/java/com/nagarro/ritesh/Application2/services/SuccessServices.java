package com.nagarro.ritesh.Application2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nagarro.ritesh.Application2.repostiory.SuccessRepo;
import com.nagarro.ritesh.Application2.models.*;

@Controller
public class SuccessServices {
	
	
	
	@Autowired
	private SuccessRepo successRepo;
	
	public  List<Transactions> getTransactions(String accNum){
		
		List transList;
		
		transList = this.successRepo.findByAccountNumberAndStatus(accNum, "success");
		
		return transList;
		
		
	}
	
	

}
