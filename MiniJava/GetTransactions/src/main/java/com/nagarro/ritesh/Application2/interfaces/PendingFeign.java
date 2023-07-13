package com.nagarro.ritesh.Application2.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nagarro.ritesh.Application2.models.Transactions;

@FeignClient(name = "PendingTransactions", url = "http://localhost:8083/backendserver3/pending/")
public interface PendingFeign {

	
	@GetMapping("{accountnumber}")
	List<Transactions> getPendingTransactions(@PathVariable String accountnumber);
}
