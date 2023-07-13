package com.nagarro.ritesh.Application2.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nagarro.ritesh.Application2.models.Transactions;

@FeignClient(name = "FailureTransactions", url = "http://localhost:8082/backendserver2/failure/")
public interface FailureFeign {

	
	
	@GetMapping("{accountnumber}")
	List<Transactions> getFailureTransactions(@PathVariable String accountnumber);
}
