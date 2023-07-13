package com.nagarro.ritesh.Application2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nagarro.ritesh.Application2.repository.PendingRepo;
import com.nagarro.ritesh.Application2.models.Transactions;
import java.util.*;

@Controller
public class PendingServices {

		@Autowired
		private PendingRepo pendingRepo;
		
		
		//To get the Pending transactions 
		public List<Transactions> getTransactions(String accNum){
			
			
			List<Transactions> transList = null;
			
			try {
				
				
				transList = this.pendingRepo.findByAccountNumberAndStatus(accNum, "pending");
			}catch(Exception e) {
				
				transList = new ArrayList<>();
			}
			
			return transList;
			
			
		}
		
		
		
		
		
		public List<Transactions> getAll(){
			
			
			List<Transactions> transList= this.pendingRepo.findAll();
			return transList;
		}
		

}
