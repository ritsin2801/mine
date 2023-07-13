package com.nagarro.ritesh.Application2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Controller;

import com.nagarro.ritesh.Application2.interfaces.FailureFeign;
import com.nagarro.ritesh.Application2.interfaces.FeignInterface;
import com.nagarro.ritesh.Application2.interfaces.PendingFeign;
import com.nagarro.ritesh.Application2.models.Transactions;

@Controller
public class TransactionsServices {

	
	@Autowired
	private FeignInterface feignInterface;
	
	@Autowired
	private PendingFeign pendingFeign;
	
	@Autowired
	private FailureFeign failureFeign;
	
	public List<Transactions> successTransactions(String accountNumber){
		
			 
		List<Transactions> transList;
		try {
			System.out.println("hii");
		
		transList = this.feignInterface.getSuccessTransactions(accountNumber);
		System.out.println(transList);
		
		}
		catch(Exception e) {
			
			System.out.println(e);
			transList = new ArrayList<>();
			
		}
		
		return transList;
	}
	
	
	public List<Transactions> failureTransactions(String accountNumber){
		
		 
		List<Transactions> transList;
		try {
			System.out.println("failure");
		
		transList = this.failureFeign.getFailureTransactions(accountNumber);
		System.out.println(transList);
		
		}
		catch(Exception e) {
			
			System.out.println(e);
			transList = new ArrayList<>();
			
		}
		
		return transList;
	}
	
	public List<Transactions> pendingTransactions(String accountNumber){
		
		 
		List<Transactions> transList;
		try {
			System.out.println("pending");
		
		transList = this.pendingFeign.getPendingTransactions(accountNumber);
		System.out.println(transList);
		
		}
		catch(Exception e) {
			
			System.out.println(e);
			transList = new ArrayList<>();
			
		}
		
		return transList;
	}
	
	
	}
	
	
	
	
		

 